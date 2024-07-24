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
val _groupId = "com.github.LiamLong11"
val _artifactId = "live-event-bus-x"
val _version = "1.11.0"
publishing { // 发布配置
    publications { // 发布的内容
        register<MavenPublication>("release") { // 注册一个名字为 release 的发布内容
            groupId = _groupId
            artifactId = _artifactId
            version = _version

            afterEvaluate { // 在所有的配置都完成之后执行
                // 从当前 module 的 release 包中发布
                from(components["release"])
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