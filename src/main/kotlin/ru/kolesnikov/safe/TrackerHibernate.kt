package ru.kolesnikov.safe

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import ru.kolesnikov.oop.Item

fun main() {
        val registry = StandardServiceRegistryBuilder().configure().build()
        try {
        val sf = MetadataSources(registry).buildMetadata().buildSessionFactory()
        val item = create(Item(name = "Learn Hibernate", 1), sf)
        println(item)
        item.name = "Learn Hibernate 5."
        update(item, sf)
        println(item)
        val rsl = findById(item.id, sf)
        println(rsl)
        delete(rsl.id, sf)
        val list = findAll(sf)
        for (it in list) {
        println(it)
        }
        } finally {
        StandardServiceRegistryBuilder.destroy(registry)
        }
        }



fun <T> SessionFactory.tx(block: Session.() -> T): T {
        val session = openSession()
        session.beginTransaction()
        val model = session.block()
        session.transaction.commit()
        session.close()
        return model
}

fun create(item: Item, sf: SessionFactory): Item =
        sf.tx { save(item); item }

fun update(item: Item?, sf: SessionFactory) {
        sf.tx { update(item) }
}

fun delete(id: Int, sf: SessionFactory) {
        sf.tx { delete(id) }
}

fun findAll(sf: SessionFactory): List<Item> =
        sf.tx { createQuery("from ru.job4j.tracker.Item").list() as List<Item> }

fun findById(id: Int?, sf: SessionFactory): Item =
        sf.tx { get(Item::class.java, id) }


/* first variant
        fun create(item: Item, sf: SessionFactory): Item {
        val session = sf.openSession()
        session.beginTransaction()
        session.save(item)
        session.transaction.commit()
        session.close()
        return item
        }

        fun update(item: Item?, sf: SessionFactory) {
        val session = sf.openSession()
        session.beginTransaction()
        session.update(item)
        session.transaction.commit()
        session.close()
        }

        fun delete(id: Int, sf: SessionFactory) {
        val session = sf.openSession()
        session.beginTransaction()
        val item = Item()
        item.id = id
        session.delete(item)
        session.transaction.commit()
        session.close()
        }

        fun findAll(sf: SessionFactory): List<Item> {
        val session = sf.openSession()
        session.beginTransaction()
        val result = session.createQuery("from ru.job4j.tracker.Item").list() as List<Item>
    session.transaction.commit()
            session.close()
            return result
            }

            fun findById(id: Int?, sf: SessionFactory): Item {
            val session = sf.openSession()
            session.beginTransaction()
            val result = session.get(Item::class.java, id)
        session.transaction.commit()
        session.close()
        return result
        }


*/