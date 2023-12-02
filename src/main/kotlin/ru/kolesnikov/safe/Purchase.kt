package ru.kolesnikov.safe

import kotlinx.html.*
import kotlinx.html.dom.create
import org.w3c.dom.Element
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

data class Purchase (
    val name: String,
    val created: Date,
    val address: Address? )

class Address(private val street: String, private val home: String, private val zip: String) {
    override fun toString(): String {
        return "Street: $street, Home: $home, Zip: $zip"
    }
}


fun getHtml(content: List<Purchase>) =  DocumentBuilderFactory
    .newInstance()
    .newDocumentBuilder()
    .newDocument()
    .create.html {
    head {
        title("Purchases")
    }
    body {
        h1("h1Class") {
            +"Table of purchases"
        }
        p("headerTable") {
            +"|Name|Date|Address|"
        }
        content.forEach { pur ->
           p("purchase") {
                +"|"
                + pur.name
                +"|"
                +pur.created.toString()
                +"|"
                +String.format("%s", pur.address ?: " ")
                +"|"
            }
        }

    }
}

fun intoStream(doc: Element, out: OutputStream) {
    with(TransformerFactory.newInstance().newTransformer()){
        transform(
            DOMSource(doc),
            StreamResult(OutputStreamWriter(out, "UTF-8"))
        )
    }
}
