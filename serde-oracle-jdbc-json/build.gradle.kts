plugins {
    id("io.micronaut.build.internal.serde-module")
}

configurations.all {
    exclude("io.micronaut", "micronaut-jackson-databind")
    exclude("io.micronaut", "micronaut-jackson-core")
}

dependencies {
    annotationProcessor(mn.micronaut.inject.java)
    annotationProcessor(projects.micronautSerdeProcessor)

    compileOnly(libs.graal.svm)
    compileOnly(mn.micronaut.jackson.databind)

    api(mn.micronaut.context)
    api(projects.micronautSerdeApi)

    implementation(projects.micronautSerdeSupport)
    implementation(libs.oracle.jdbc.driver)

    testAnnotationProcessor(mn.micronaut.inject.java)
    testAnnotationProcessor(projects.micronautSerdeProcessor)

    testCompileOnly(mn.micronaut.inject.groovy)

    testImplementation(mn.jackson.annotations)
    testImplementation(projects.micronautSerdeProcessor)
    testImplementation(projects.micronautSerdeTck)
    testImplementation(mn.micronaut.inject.java.test)
    testImplementation(mnTest.micronaut.test.junit5)
    testImplementation(mn.micronaut.http.server.netty)
    testImplementation(mn.micronaut.http.client)
    testImplementation(mnTest.micronaut.test.spock)
    testImplementation(mnReactor.micronaut.reactor)

    testRuntimeOnly(libs.junit.jupiter.engine)
}

tasks {
    test {
        useJUnitPlatform()
    }
}
