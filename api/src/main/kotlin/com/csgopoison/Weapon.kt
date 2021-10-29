package com.csgopoison

interface Weapon : Entity {
	
	val bullets: Long
	
	val nextPrimaryAttack: Float
	
	val canFire: Boolean
	
}