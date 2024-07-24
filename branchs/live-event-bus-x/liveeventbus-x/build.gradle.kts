import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
}

android {
    compileSdk = 34

    defaultConfig {
        minSdk = 23
        targetSdk = 34
    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata:2.2.0")
}


//=============================maven publish start=============================
val _groupId = "com.donnermusic"
val _artifactId = "live-event-bus-x"
val _version = "1.9.0"
afterEvaluate {
    publishing {
        publications {
// Creates a Maven publication called “release”.
//            create("release") {
//// Applies the component for the release build variant.
//// from(components["release"])
//// You can then customize attributes of the publication as shown below.
//                group = _groupId
//                artifactId = _artifactId
//                version = _version
//            }
            register("live-event-bus-x", MavenPublication::class){
                group = _groupId
                artifactId = _artifactId
                version = _version
            }
        }
    }
}

//publishing {
//    publications {
//        register("live-event-bus-x", MavenPublication::class) {
//            groupId = _groupId
//            artifactId = _artifactId
//            version = _version
//            // 依赖 bundleReleaseAar 任务，并上传其产出的aar
//            afterEvaluate { artifact(tasks.getByName("bundleReleaseAar")) }
//            // 上传source，这样使用可以看到方法注释
//            //artifact generateSourcesJar
//            // pom文件中声明依赖，从而传递到使用方
//            pom.withXml {
//                val dependenciesNode = asNode().appendNode("dependencies")
//                configurations.implementation.get().allDependencies.forEach {
//                    // 避免出现空节点或 artifactId=unspecified 的节点
//                    if (it.group != null && (it.name != null && it.name != "unspecified") && it.version != null) {
//                        println(it.toString())
//                        val dependencyNode = dependenciesNode.appendNode("dependency")
//                        dependencyNode.appendNode("groupId", it.group)
//                        dependencyNode.appendNode("artifactId", it.name)
//                        dependencyNode.appendNode("version", it.version)
//                        dependencyNode.appendNode("scope", "implementation")
//                    }
//                }
//            }
//        }
//    }
//
//
//    var _url = ""
//    var _username = ""
//    var _password = ""
//
//    var properties = Properties()
//    var file = file("maven.properties")
//    if (file.exists()) {
//        properties.load(FileInputStream(file))
//        _url = properties["url"] as String
//        _username = properties["username"] as String
//        _password = properties["password"] as String
//    }
//
//    repositories {
//        maven(url = _url) {
//            credentials {
//                username = _username
//                password = _password
//            }
//        }
//    }
//}
//=============================maven publish end=============================