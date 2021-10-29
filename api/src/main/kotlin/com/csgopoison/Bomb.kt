package com.csgopoison

interface Bomb : Entity {
	
	val defused: Boolean
	
	val blowTime: Float
	
	val defuseTime: Float
	
	val defuserPointer: Long
	
	val owner: Long
	
}