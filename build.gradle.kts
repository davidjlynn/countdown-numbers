plugins {
  java
  alias(libs.plugins.springBoot)
  alias(libs.plugins.springDependencyManagement)
  jacoco
  alias(libs.plugins.sonarqube)
  alias(libs.plugins.benManesVersions)
  alias(libs.plugins.spotless)
  alias(libs.plugins.nebulaRelease)
  `maven-publish`
}

group = "com.davidjlynn"

java { toolchain { languageVersion = JavaLanguageVersion.of(21) } }

configurations { compileOnly { extendsFrom(configurations.annotationProcessor.get()) } }

repositories { mavenCentral() }

extra["springShellVersion"] = "3.4.0"

dependencies {
  implementation("org.springframework.shell:spring-shell-starter")
  compileOnly("org.projectlombok:lombok")
  annotationProcessor("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.shell:spring-shell-starter-test")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
  imports {
    mavenBom(
      "org.springframework.shell:spring-shell-dependencies:${property("springShellVersion")}"
    )
  }
}

tasks.withType<Test> { useJUnitPlatform() }

tasks.test { finalizedBy(tasks.jacocoTestReport) }

tasks.jacocoTestReport {
  dependsOn(tasks.test)
  reports { xml.required = true }
}

sonar {
  properties {
    property("sonar.host.url", "https://sonarcloud.io")
    property("sonar.organization", "davidjlynn")
    property("sonar.projectKey", "davidjlynn_countdown-numbers")
  }
}

spotless {
  format("misc") {
    target(".gitattributes", ".gitignore")
    trimTrailingWhitespace()
    leadingTabsToSpaces(2)
    endWithNewline()
  }
  java {
    importOrder()
    removeUnusedImports()
    googleJavaFormat()
    formatAnnotations()
  }
  kotlinGradle { ktfmt().googleStyle() }
}

tasks.release { dependsOn(tasks.publish) }

publishing {
  publications { create<MavenPublication>("mavenJava") { artifact(tasks.named("bootJar")) } }
  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/davidjlynn/countdown-numbers")
      credentials {
        username = System.getenv("GITHUB_ACTOR")
        password = System.getenv("GITHUB_TOKEN")
      }
    }
  }
}
