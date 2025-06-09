plugins {
    id("java")
    kotlin("jvm") version "2.0.21"
}

group = "icu.azusachino"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
