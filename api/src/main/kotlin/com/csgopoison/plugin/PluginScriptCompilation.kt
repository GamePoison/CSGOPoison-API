package com.csgopoison.plugin

import com.csgopoison.netvars.NetVars
import com.csgopoison.offsets.ClientOffsets
import com.csgopoison.offsets.EngineOffsets
import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.defaultImports
import kotlin.script.experimental.api.implicitReceivers

object PluginScriptCompilation : ScriptCompilationConfiguration({
	defaultImports(
		"org.gamepoison.*",
		"org.gamepoison.native.*",
		
		"com.csgopoison.*",
		"com.csgopoison.plugin.*",
	)
	implicitReceivers(NetVars::class, ClientOffsets::class, EngineOffsets::class)
})