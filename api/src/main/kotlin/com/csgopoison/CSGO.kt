package com.csgopoison

import com.badlogic.gdx.utils.ScreenUtils
import com.csgopoison.Console.log
import com.csgopoison.input.UserInput
import com.csgopoison.plugin.PluginScript
import org.gamepoison.ClassLoading
import org.gamepoison.Game

interface CSGO : Game, CSGOContext, GameInfo {
	override val name get() = "CSGO"

	fun startPlatform()
	
	override fun start() {
		CSGOState.csgo = this
		
		startPlatform()
		netVars.load()

		ClassLoading.load(PluginScript::class) {
			constructors.first().call(this@CSGO, overlay, userInput, netVars, clientOffsets, engineOffsets, entityManager)
		}

		overlay.open {
			log(1, "Overlay Opened")
		}
	}
	
	override fun process() {
		//TODO overlay.open here?
	}
}