import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("kotlin")
    id("maven-publish")
    id("org.jetbrains.dokka")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

publishing {
    publications {
        create<MavenPublication>("maven"){
            groupId = "com.jemshit.walletconnect"
            artifactId = "walletconnect-store-file"
            version = "0.0.1"

            from(components["java"])
        }
    }
}

dependencies {
    api(project(":walletconnect-core"))
    testImplementation(testFixtures(project(":walletconnect-core")))
    dokkaJavadocPlugin(Dependencies.kotlinDokka)

    implementation(Dependencies.kotlinJDK8)
    implementation(Dependencies.kotlinCoroutines)
    testImplementation(Dependencies.kotlinCoroutinesTest)
    implementation(Dependencies.gson)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.androidxJunitKtx)
}
