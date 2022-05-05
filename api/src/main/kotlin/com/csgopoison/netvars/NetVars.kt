package com.csgopoison.netvars

interface NetVars {
	
	fun netVar(className: String, varName: String? = null, offset: Int = 0, index: Int = -1) =
		NetVar(this, className, if (varName != null && index >= 0) "$varName[$index]" else varName, offset, index)
	
	fun load()
	
	fun hashClassAndVar(className: String, varName: String) = className.hashCode() xor varName.hashCode()
	
	operator fun get(classAndVarHash: Int): NetVarClassOffset?
	
	fun toNetVarString(bytes: ByteArray): String {
		for (i in 0..bytes.size - 1) if (0.toByte() == bytes[i]) bytes[i] = 32
		return String(bytes).split(" ")[0].trim()
	}
	
	val dwModel: Long
	val iTeamNum: Long
	val bSpotted: Long
	val bSpottedByMask: Long
	val vecOrigin: Long
	
	val iCompetitiveRanking: Long
	val aimPunchAngle: Long
	
	val fFlags: Long
	val lifeState: Long
	val vecPunch: Long
	val szLastPlaceName: Long
	val iHealth: Long
	val vecViewOffset: Long
	val vecVelocity: Long
	val hActiveWeapon: Long
	val nTickBase: Long
	
	val flFlashMaxAlpha: Long
	val iCrossHairID: Long
	val iShotsFired: Long
	val bIsScoped: Long
	val bHasDefuser: Long
	val nSurvivalTeam: Long
	
	val flC4Blow: Long
	val bBombDefused: Long
	val hBombDefuser: Long
	val flDefuseCountDown: Long
	
	val hOwnerEntity: Long
	
	val dwBoneMatrix: Long
	
	val flNextPrimaryAttack: Long
	val iClip1: Long
	val iClip2: Long
	
	val iItemDefinitionIndex: Long
	
	val SurvivalGameRuleDecisionTypes: Long
	
	val m_hViewModel: Long
	
}