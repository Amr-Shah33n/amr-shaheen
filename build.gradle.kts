plugins {
    id("java")
}

group = "org.moneyapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("org.apache.logging.log4j:log4j-core")
    implementation(platform("org.junit:junit-bom:5.10.0"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("org.seleniumhq.selenium:selenium-java:4.28.0")
    implementation("io.appium:java-client:9.4.0")
    implementation("org.assertj:assertj-core:3.27.2")
    implementation("com.browserstack:browserstack-java-sdk:1.30.6")
    implementation ("org.apache.logging.log4j:log4j-bom:2.24.3")
    implementation("org.apache.logging.log4j:log4j-core:2.24.3")
    implementation("org.apache.logging.log4j:log4j-api:2.24.3")
    implementation(platform("io.qameta.allure:allure-bom:2.25.0"))
    testImplementation("io.qameta.allure:allure-junit5")
}

tasks.test {
    val pathToBrowserStackSdk = project.configurations.getByName("runtimeClasspath").find { it.name.startsWith("browserstack-java-sdk-") }
    pathToBrowserStackSdk.takeIf { it != null }?.let { println("Found BrowserStack SDK - $it") } ?: throw StopExecutionException("BrowserStack SDK NOT found. Test execution exited.")
    jvmArgs("-javaagent:${pathToBrowserStackSdk}")
    useJUnitPlatform()
}