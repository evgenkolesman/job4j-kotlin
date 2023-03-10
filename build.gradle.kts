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
    testImplementation(kotlin("test", "1.8.0-RC"))
    testImplementation ("io.kotlintest:kotlintest-runner-junit5:3.4.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(14)
}

application {
    mainClass.set("MainKt")
}