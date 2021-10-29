plugins {
	kotlin("jvm")
	`java-library`
	`maven-publish`
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			artifactId = "api"
			from(components["java"])
		}
	}
}

allprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	
	group = "com.csgopoison"
	version = "0.1.0"
	
	repositories {
		mavenLocal()
		mavenCentral()
	}
	
	java {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
		
		withJavadocJar()
		withSourcesJar()
	}
	
	tasks {
		compileKotlin {
			kotlinOptions.jvmTarget = "11"
		}
		compileTestKotlin {
			kotlinOptions.jvmTarget = "11"
		}
	}
}

subprojects {
	apply(plugin = "org.gradle.maven-publish")
	
	publishing {
		publications {
			create<MavenPublication>("maven") {
				artifactId = project.path.substring(1).replace(':', '-')
				from(components["java"])
			}
		}
	}
}