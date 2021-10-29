package com.csgopoison.netvars

import kotlin.reflect.KProperty

class NetVar(
	val netVars: NetVars,
	
	val className: String,
	var varName: String?,
	val offset: Int,
	val index: Int,
) {
	
	private var value = -1L
	
	operator fun getValue(thisRef: Any?, property: KProperty<*>): Long {
		if (varName == null) varName = "m_${property.name}" + if (index < 0) "" else "[$index]"
		if (value == -1L) value = netVars[netVars.hashClassAndVar(className, varName!!)]!!.offset + offset
		return value
	}
	
	operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
		this.value = value
	}
	
}