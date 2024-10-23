plugins {
    kotlin("jvm") version "2.0.20"
    `maven-publish`
}

group = "io.github.shiniseong"
version = "1.0.1.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}