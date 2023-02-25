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
    implementation(project(":application-services"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("org.springframework.boot:spring-boot-starter-web:3.0.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}