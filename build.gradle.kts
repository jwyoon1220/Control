plugins {
    kotlin("jvm") version "2.0.20"
}

group = "io.jwyoon1220"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
    implementation("io.github.monun:kommand-api:3.1.7")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}