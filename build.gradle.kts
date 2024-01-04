plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "ru.kolesnikov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val kotlinxHtmlVersion = "0.10.1"
    val dbcp2Version = "2.11.0"
    val hibernateVersion = "5.4.20.Final"
    val postgresVersion = "42.5.1"
    val junitKotlinRunnerVersion = "3.4.2"

    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinxHtmlVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-html:$kotlinxHtmlVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")
    implementation("org.apache.commons:commons-dbcp2:$dbcp2Version")
    testImplementation(kotlin("test", "1.8.0-RC"))
    testImplementation("io.kotlintest:kotlintest-runner-junit5:$junitKotlinRunnerVersion")
    compileOnly("org.hibernate:hibernate-core:$hibernateVersion")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}