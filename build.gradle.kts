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

    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinxHtmlVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-html:$kotlinxHtmlVersion")
    implementation("org.postgresql:postgresql:42.5.1")
    implementation("org.apache.commons:commons-dbcp2:$dbcp2Version")
    testImplementation(kotlin("test", "1.8.0-RC"))
    testImplementation ("io.kotlintest:kotlintest-runner-junit5:3.4.2")
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