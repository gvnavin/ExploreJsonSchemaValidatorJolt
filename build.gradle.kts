import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("com.bazaarvoice.jolt:jolt-core:0.1.7")
    // https://mvnrepository.com/artifact/com.bazaarvoice.jolt/json-utils
    implementation("com.bazaarvoice.jolt:json-utils:0.1.7")

    // https://mvnrepository.com/artifact/com.bazaarvoice.jolt/jolt-complete
    implementation("com.bazaarvoice.jolt:jolt-complete:0.1.7")

    implementation("com.networknt:json-schema-validator:1.0.72")

    implementation("org.skyscreamer:jsonassert:1.5.0")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}