package com.csgopoison.netvars

import org.gamepoison.native.Source

interface NetVarClassVariable : Source {
	
	val addressOffset: Long
	
	val resolvedAddress: Long
	
	val name: String
	
	val table: Long
	
	val offset: Long
	
	val type: Long
	
	val elements: Long
	
	val stringBufferCount: Long
	
}