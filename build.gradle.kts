import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    // repository needed for plugin kotlinder-gradle, used to apply ktlint
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        // plugin for ktlint, project at this repo: https://github.com/jeremymailen/kotlinter-gradle
        classpath("org.jmailen.gradle:kotlinter-gradle:2.1.1")
    }
}


plugins {
    kotlin("jvm") version "1.3.41"
    kotlin("plugin.jpa") version "1.3.41" apply false
    kotlin("plugin.spring") version "1.3.41" apply false
    kotlin("plugin.allopen") version "1.3.41" apply false
    id("io.spring.dependency-management") version "1.0.7.RELEASE" apply false
    id("org.springframework.boot") version "2.1.7.RELEASE" apply false
}

allprojects {

    group = "com.audhumla.mservices"
    version = "0.0.1-SNAPSHOT"

    repositories {
        jcenter() // superset of maven central
    }

}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}
subprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            // Enable Interoperability with Java
            freeCompilerArgs = listOf("-Xjsr305=strict")
            // Target Java 11
            jvmTarget = "1.8"
        }

        // Enable warning
        kotlinOptions.allWarningsAsErrors = true
    }


    tasks.register("hello") {
        doLast {
            println("I'm ${this.project.name}")
        }
    }

}
// User Service specific stuff
project("user-service") {

    tasks.withType<Test> {
        println("Configuring tests for  ${this.project.name}")

        /* Use Junit Platform for tests */
        useJUnitPlatform()
    }

}
