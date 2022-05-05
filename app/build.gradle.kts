plugins {
	`java-library`
}

val fastutil by extra("it.unimi.dsi:fastutil:8.5.6")
val gdxVersion by extra("1.10.0")

dependencies {
	implementation(kotlin("reflect"))
	
	implementation(kotlin("scripting-common"))

	implementation("org.gamepoison.internal", "api-native-jna", "0.1.0")
	implementation("org.gamepoison.internal", "api-native-jna-windows", "0.1.0")

	implementation("com.csgopoison", "api", "0.1.0")

	implementation("com.badlogicgames.gdx:gdx:$gdxVersion")
	implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:$gdxVersion")
	implementation("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")

	implementation(fastutil)

	api("org.gamepoison", "api", "0.1.0")
	api("org.gamepoison", "api-native", "0.1.0")
}