package com.csgopoison.plugin

import com.csgopoison.CSGO
import com.csgopoison.CSGOContext
import kotlin.script.experimental.annotations.KotlinScript

@KotlinScript(
	"CSGOPoison",
	fileExtension = "csgopoison.kts",
	compilationConfiguration = PluginScriptCompilation::class
)
abstract class PluginScript(val csgo: CSGO) : CSGOContext by csgo {
	
	fun testor() {
		println("JAJA!")
	}
	
	fun dude() {
		println("COOL BEANS")
	}
	
}