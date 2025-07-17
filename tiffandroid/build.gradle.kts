plugins {
    alias(libs.plugins.android.library)
    id("com.vanniktech.maven.publish") version "0.34.0"
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
}

afterEvaluate {
    mavenPublishing {
        coordinates("io.github.alexandermatveychuk", "tiffandroid", libVersion)

        pom {
            name.set("TiffAndroid")
            description.set("Android wrapper for libtiff. Renders tiff to android Bitmap, converts to other image formats, can encode tiff image.")
            inceptionYear.set("2025")
            url.set("https://github.com/alexandermatveychuk/tiffandroid")
            licenses {
                license {
                    name.set("The MIT License (MIT)")
                    url.set("https://mit-license.org/")
                    distribution.set("repo")
                }
            }
            developers {
                developer {
                    id.set("alexandermatveychuk")
                    name.set("Alexander Matveychuk")
                    url.set("https://github.com/alexandermatveychuk")
                }
            }
            scm {
                url.set("https://github.com/alexandermatveychuk/tiffandroid")
                connection.set("scm:git:git://github.com/alexandermatveychuk/tiffandroid.git")
                developerConnection.set("scm:git:ssh://git@github.com/alexandermatveychuk/tiffandroid.git")
            }
        }

        publishToMavenCentral()

        signAllPublications()
    }
}
