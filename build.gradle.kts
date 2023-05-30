import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.asciidoctor.jvm.convert") version "3.3.2"
	kotlin("jvm") version "1.8.21"
	kotlin("plugin.spring") version "1.8.21"
	kotlin("plugin.jpa") version "1.8.21"
}

group = "com.jcs"
version = "0.0.1-SNAPSHOT"
sourceCompatibility = '17'

repositories {
	mavenCentral()
}

extra["snippetsDir"] = file("build/generated-snippets")

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc.springdoc-openapi-webmvc-ui:2.0.2")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.flywaydb:flyway-core")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
	}

tasks.withType(KotlinCompile).configureEach {
	kotlinOptions {
		freeCompilerArgs = ['-Xjsr305=strict']
		jvmTarget = '17'
	}
}

tasks.named('test') {
	useJUnitPlatform()
}
