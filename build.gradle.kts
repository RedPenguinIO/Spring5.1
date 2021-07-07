import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.20"
    kotlin("plugin.spring") version "1.5.20"
    kotlin("plugin.jpa") version "1.5.20"
}

group = "io.peng"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    /*implementation("org.springframework.boot:spring-boot-starter-batch")
    *     implementation("org.springframework.boot:spring-boot-starter-web-services")
*/
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-integration")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework:spring-webmvc:4.0.0.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.integration:spring-integration-jpa")
    implementation("org.springframework.integration:spring-integration-security")
    implementation("org.springframework.integration:spring-integration-ws")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.batch:spring-batch-test")
    testImplementation("org.springframework.integration:spring-integration-test")
    testImplementation("org.springframework.security:spring-security-test")
    implementation("org.springframework.webflow:spring-webflow:2.5.1.RELEASE")
    implementation("org.springframework:spring-context")
    implementation("org.springframework:spring-aop")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework:spring-web")
    implementation("org.springframework:spring-webmvc")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
