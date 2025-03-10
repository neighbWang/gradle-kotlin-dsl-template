plugins {
    `java-gradle-plugin`
    kotlin("jvm")
    kotlin("kapt")
    id("io.johnsonlee.sonatype-publish-plugin")
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    kapt("com.google.auto.service:auto-service:1.0")
    implementation("com.google.auto.service:auto-service:1.0")
    implementation("com.didiglobal.booster:booster-gradle-plugin:4.0.0")
    implementation("com.didiglobal.booster:booster-api:4.0.0")
    implementation("com.didiglobal.booster:booster-transform-asm:4.0.0")
    compileOnly("com.android.tools.build:gradle:4.0.0")
    implementation(kotlin("bom"))
    implementation(kotlin("stdlib"))
}

sourceSets {

    main {
        java {
            srcDirs("../buildSrc/src/main/java")
        }
    }
}

gradlePlugin {
    plugins {
        create("TemplatePlugin") {
            id = "io.neighbwang.template-gradle-plugin"
            implementationClass = "io.neighbwang.template.gradle.TemplatePlugin"
        }
    }
}