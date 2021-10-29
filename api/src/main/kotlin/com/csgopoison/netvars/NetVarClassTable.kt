package com.csgopoison.netvars

import org.gamepoison.native.Source

interface NetVarClassTable : Source {
	
	val offset: Long
	
	val name: String
	
	val propCount: Int
	
	fun propForID(id: Int): Long
	
	val readable: Boolean
	
}