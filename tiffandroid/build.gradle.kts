plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

val libVersion = "0.10.0"

android {
    namespace = "org.beyka.tiffbitmapfactory"

    compileSdk = 36

    buildFeatures {
        buildConfig = true
        prefab = true
    }

    defaultConfig {
        minSdk = 26

        consumerProguardFiles("proguard-rules.pro")
        buildConfigField("String", "softwarename", "\"${project.name}-$libVersion\"")

        ndk {
            abiFilters += arrayOf("arm64-v8a", "armeabi-v7a", "x86_64")
        }
    }

    ndkVersion = "27.2.12479018"

    externalNativeBuild {
        ndkBuild {
            path("src/main/jni/Android.mk")
        }
    }

    splits {
        abi {
            isEnable = true
            reset()
            include("arm64-v8a", "armeabi-v7a", "x86_64")
            isUniversalApk = false
        }
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "io.github.alexandermatveychuk"
                artifactId = "tiffandroid"
                version = libVersion

                from(components["release"])
            }
        }

        repositories {
            maven {
                name = "MavenCentral"
                url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
                credentials {
                    username = System.getenv("MVNCENTRAL_USERNAME")
                    password = System.getenv("MVNCENTRAL_PASSWORD")
                }
            }
        }
    }
}
