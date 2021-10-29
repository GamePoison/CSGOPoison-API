plugins {
	`java-library`
}

dependencies {
	implementation(kotlin("reflect"))
	
	implementation(kotlin("scripting-common"))
	
	api("org.gamepoison", "api", "0.1.0")
	api("org.gamepoison", "api-native", "0.1.0")
}