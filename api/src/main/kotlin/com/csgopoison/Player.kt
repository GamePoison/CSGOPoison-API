package com.csgopoison

interface Player : Entity {
	
	val weaponIndex: Int
	
	val flags: Int
	
	val onGround get() = flags and 1 == 1
	
	val health: Int
	
	val lifeState: Int
	
	val dead get() = lifeState != 0 || health <= 0
	
	val shotsFired: Int
	
	val boneMatrix: Long
	
	val isScoped: Boolean
	
	val hasDefuser: Boolean
	
	val time: Double
	
}