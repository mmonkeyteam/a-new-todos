plugins {
    kotlin("jvm")
    kotlin("plugin.jpa")
    kotlin("plugin.spring")
    // Necessary to avoid final on classes annotate with some Jpa annotations
    kotlin("plugin.allopen")

    // Apply the application plugin to add support for building a CLI application.
    application

    id("io.spring.dependency-management")
    id("org.springframework.boot")
    // plugin for ktlint
    id("org.jmailen.kotlinter")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // enable introspection of Kotlin’s nullability constraints
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Import tests with Junit
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        // Without this exclusion there are problem in executing the tests with Junit5
        // (classpath conflict problem?)
        exclude(module = "junit")
    }
    testImplementation("com.h2database:h2")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

application {
    mainClassName = "com.audhumla.mservices.user.UserServiceApplication"
    applicationName = "user-service"
}

// apply plugin for ktlint
//apply(plugin = "org.jmailen.kotlinter")
