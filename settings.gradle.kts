pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/JavGarCas/kt-string")

            val prop = java.util.Properties().apply {
                load(java.io.FileInputStream(File(rootProject.projectDir, "github.properties")))
            }
            println(prop.getProperty("gpr.usr"))
            println(prop.getProperty("gpr.key"))
            credentials {
                username = prop.getProperty("gpr.usr") ?: System.getenv("GPR_USER")
                password = prop.getProperty("gpr.key") ?: System.getenv("GPR_API_KEY")
            }
        }
    }
}

rootProject.name = "Demo Extensions"
include(":app")
include(":ktstring")
