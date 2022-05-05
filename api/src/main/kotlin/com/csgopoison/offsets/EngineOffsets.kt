package com.csgopoison.offsets

interface EngineOffsets {
	val dwClientState: Long
	val dwClientStateNetChannel: Long
	val dwClientStateLastOutgoingCommand: Long
	val dwClientStateChokedCommands: Long

	val dwGlobalVars: Long
	val dwViewAngles: Long
	
	val dwSignOnState: Long
	
	val pStudioModel: Long
	val dwModelAmbientMin: Long

	val dwbSendPackets: Long
}