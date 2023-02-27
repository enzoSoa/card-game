plugins {
    kotlin("jvm")
    id("org.springframework.boot") version "3.0.2"
}

group = "com.esgi"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

springBoot {
    mainClass.set("com.esgi.Application")
}

dependencies {
    implementation(project(":domain-models"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("org.springframework.boot:spring-boot-starter-web:3.0.3")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.0.3")
    implementation("org.springframework.data:spring-data-mongodb:3.3.5")
    implementation("org.mongodb:mongodb-driver-sync:4.5.0")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
    implementation(project(mapOf("path" to ":domain-services")))
    implementation(project(mapOf("path" to ":application-services")))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}