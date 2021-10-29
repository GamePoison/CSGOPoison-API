package com.csgopoison

import com.csgopoison.netvars.NetVars
import com.csgopoison.offsets.ClientOffsets
import com.csgopoison.offsets.EngineOffsets
import org.gamepoison.native.Module
import org.gamepoison.native.Process

interface CSGOContext {
	
	val process: Process get() = CSGOState.csgo.process
	
	val clientModule: Module get() = CSGOState.csgo.clientModule
	val engineModule: Module get() = CSGOState.csgo.engineModule
	
	val netVars: NetVars get() = CSGOState.csgo.netVars
	
	val clientOffsets: ClientOffsets get() = CSGOState.csgo.clientOffsets
	val engineOffsets: EngineOffsets get() = CSGOState.csgo.engineOffsets
	
	fun entity(address: Long): Entity = CSGOState.csgo.entity(address)
	fun player(address: Long): Player = CSGOState.csgo.player(address)
	
	fun entityType(address: Long): EntityType = CSGOState.csgo.entityType(address)
	
}