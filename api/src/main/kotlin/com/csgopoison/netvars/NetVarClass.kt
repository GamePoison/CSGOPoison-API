package com.csgopoison.netvars

import org.gamepoison.native.Source

interface NetVarClass : Source {
	
	val id: Long
	
	val next: Long
	
	val table: Long
	
	val readable: Boolean
	
}