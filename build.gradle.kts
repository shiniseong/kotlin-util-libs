import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

private val _group = "io.github.shiniseong"
private val _version = "1.0.1.4-SNAPSHOT"
private val _name = "kotlin-util-libs"

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()
    sourceSets {
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        commonMain.dependencies {

        }
    }
}

android {
    namespace = "io.github.shiniseong.kotlin.util.libs"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
group = _group
version = _version

repositories {
    mavenCentral()
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