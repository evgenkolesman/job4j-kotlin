package ru.kolesnikov.dsl

import org.apache.commons.dbcp2.BasicDataSource

class BasicDataSourceFactory {

    var basicDataSource = BasicDataSource()
    fun build() = basicDataSource
    fun driverClassName(driver:String) =  apply { basicDataSource.setDriverClassName(driver)}
    fun url(url:String) = apply { basicDataSource.setUrl(url) }
    fun userName(userName:String) = apply { basicDataSource.setUsername(userName) }
    fun password(password:String) = apply { basicDataSource.setPassword(password) }
    fun minIdle(minIdle:Int) = apply { basicDataSource.setMinIdle(minIdle) }
    fun maxIdle(maxIdle:Int) = apply { basicDataSource.setMinIdle(maxIdle) }
    fun maxOpenPreparedStatements(maxOpenPreparedStatements:Int) = apply { basicDataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements) }


}

fun createBuilder() = BasicDataSourceFactory()


fun main() {
    val dataSource = createBuilder()
        .driverClassName("org.postgres.Driver")
        .url("localhost")
        .userName("postgres")
        .password("password")
        .minIdle(50)
        .maxIdle(10)
        .maxOpenPreparedStatements(100)
        .build()
}