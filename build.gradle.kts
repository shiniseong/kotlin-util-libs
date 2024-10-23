private val _group = "io.github.shiniseong"
private val _version = "1.0.1.2-SNAPSHOT"
private val _name = "kotlin-util-libs"

plugins {
    kotlin("jvm") version "2.0.20"
    `maven-publish`
}

group = _group
version = _version

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

publishing {
    publications {
        create<MavenPublication>("mavenKotlin") {
            from(components["kotlin"])

            groupId = _group
            artifactId = _name
            version = _version

            pom {
                name.set("Kotlin Util Libraries")
                description.set("Kotlin Util Libraries")
                url.set("https://github.com/shiniseong/$_name")

                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("shiniseong")
                        name.set("HEESEONG SHIN")
                        email.set("hss275989@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/shiniseong/$_name.git")
                    developerConnection.set("scm:git:ssh://github.com/shiniseong/$_name.git")
                    url.set("https://github.com/shiniseong/$_name")
                }
            }
        }
    }
}