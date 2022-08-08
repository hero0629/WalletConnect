import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("kotlin")
    id("maven-publish")
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
            artifactId = "walletconnect-adapter-gson"
            version = "0.0.1"

            from(components["java"])
        }
    }
}

dependencies {
    api(project(":walletconnect-core"))
    testImplementation(testFixtures(project(":walletconnect-core")))

    implementation(Dependencies.kotlinJDK8)
    api(Dependencies.moshi)
    api(Dependencies.moshiKotlinReflection)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.androidxJunitKtx)
}
