package ru.kolesnikov.safe

import ru.kolesnikov.dsl.createBuilder
import ru.kolesnikov.oop.Item

fun createConnection() =
    createBuilder()
        .driverClassName("org.postgresql.Driver")
        .url("jdbc:postgresql://localhost:5440/postgres")
        .userName("postgres")
        .password("Password")
        .minIdle(50)
        .maxIdle(10)
        .maxOpenPreparedStatements(100)
        .build()
    .getConnection()




fun insertItem(
    source: Item
): Int {
    val prepareStatement = createConnection()
        .prepareStatement("INSERT INTO kotlin.item(name) values (?) RETURNING id")
    prepareStatement.setString(1, source.name)
    val result = prepareStatement.executeQuery()
    result.next()
    return result.getInt(1)
}

fun updateItem(
    source: Item
) {
    val prepareStatement = createConnection()
        .prepareStatement("UPDATE kotlin.item SET name = ? WHERE id = ?")
    prepareStatement.setString(1, source.name)
    prepareStatement.setInt(2, source.id)
    prepareStatement.execute()
}

fun deleteItem(
    source: Item
) {
    val prepareStatement = createConnection().prepareStatement("DELETE FROM kotlin.item WHERE id = ?")
    prepareStatement.setInt(1, source.id)
    prepareStatement.execute()
}

fun getItemById(
    id: Int
): Item {
    val prepareStatement = createConnection().prepareStatement("SELECT id, name from kotlin.item WHERE id = ?")
    prepareStatement.setInt(1, id)
    val result = prepareStatement.executeQuery()
    return if(result.next()) {
        Item(result.getString("name"), result.getInt("id"))
    } else throw IllegalArgumentException("Item with $id not found")
}

fun Item.save() = insertItem(this)
fun Item.update() = updateItem(this)
fun Item.delete() = deleteItem(this)
fun Item.getById() = getItemById(this.id)


fun main() {
    val  itemInsert = Item("Super")

    val id = itemInsert.save()
    println(id)
    itemInsert.id = id
    itemInsert.name = "Super1"
    itemInsert.update()
    println(itemInsert.getById())
    itemInsert.delete()
}



