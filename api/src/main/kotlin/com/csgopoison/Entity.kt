package com.csgopoison

interface Entity : CSGOSource {
	val spotted: Boolean
	
	val dormant: Boolean
	
	val team: Long
	
	val survivalTeam: Long
	
	val model: Long
	
	val studioHdr: Long
	
	val type: EntityType

	fun absPosition(): Vector
}