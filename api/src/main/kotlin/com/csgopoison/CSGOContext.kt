package com.csgopoison

import com.csgopoison.input.UserInput
import com.csgopoison.netvars.NetVars
import com.csgopoison.offsets.ClientOffsets
import com.csgopoison.offsets.EngineOffsets
import com.csgopoison.usercmd.DwInput
import com.csgopoison.usercmd.GlobalVars
import org.gamepoison.native.Module
import org.gamepoison.native.Process
import java.awt.Robot

interface GameInfo {
	val csgoX: Int get() = CSGOState.csgo.csgoX
	val csgoY: Int get() = CSGOState.csgo.csgoY

	val csgoWidth: Int get() = CSGOState.csgo.csgoWidth
	val csgoHeight: Int get() = CSGOState.csgo.csgoHeight
}

interface CSGOContext : GameInfo {
	val process: Process get() = CSGOState.csgo.process
	
	val clientModule: Module get() = CSGOState.csgo.clientModule
	val engineModule: Module get() = CSGOState.csgo.engineModule
	
	val netVars: NetVars get() = CSGOState.csgo.netVars
	
	val clientOffsets: ClientOffsets get() = CSGOState.csgo.clientOffsets
	val engineOffsets: EngineOffsets get() = CSGOState.csgo.engineOffsets

	val globalVars: GlobalVars get() = CSGOState.csgo.globalVars

	val entityManager: EntityManager get() = CSGOState.csgo.entityManager

	val userInput: UserInput get() = CSGOState.csgo.userInput

	val dwInput: DwInput get() = CSGOState.csgo.dwInput

	val overlay: Overlay get() = CSGOState.csgo.overlay
	
	fun entity(address: Long): Entity = CSGOState.csgo.entity(address)
	fun player(address: Long): Player = CSGOState.csgo.player(address)
	
	fun entityType(address: Long): EntityType = CSGOState.csgo.entityType(address)
	
}