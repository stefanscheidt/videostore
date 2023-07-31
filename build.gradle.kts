plugins {
    java
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // https://junit.org/junit5/docs/current/user-guide/
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://assertj.github.io/doc/
    // https://github.com/assertj/assertj-examples
    testImplementation("org.assertj:assertj-core:3.24.2")

    // https://site.mockito.org/
    // https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html
    testImplementation("org.mockito:mockito-core:5.4.0")
}
