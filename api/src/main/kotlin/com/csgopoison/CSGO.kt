package com.csgopoison

import com.csgopoison.plugin.PluginScript
import org.gamepoison.ClassLoading
import org.gamepoison.Game

interface CSGO : Game, CSGOContext {
	
	override val name get() = "CSGO"
	
	fun startPlatform()
	
	override fun start() {
		CSGOState.csgo = this
		
		startPlatform()
		netVars.load()
		
		ClassLoading.load(PluginScript::class) {
			constructors.first().call(this@CSGO, netVars, clientOffsets, engineOffsets)
		}
	}
	
	override fun process() {
	
	}
	
}