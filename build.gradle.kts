
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.7"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
}

group = "com.mongodb"
version = "0.0.1"

application {
    mainClass.set("com.mongodb.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-serialization-gson-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("io.ktor:ktor-server-tomcat-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    //swagger
    implementation("io.ktor:ktor-server-swagger:$ktor_version")

    // coroutines + mongodb
    implementation("org.mongodb:mongodb-driver-kotlin-coroutine:4.10.1")

    // koin
    implementation("io.insert-koin:koin-ktor:3.6.0-wasm-alpha2")
    implementation("io.insert-koin:koin-logger-slf4j:3.6.0-wasm-alpha2")

    // tests
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
