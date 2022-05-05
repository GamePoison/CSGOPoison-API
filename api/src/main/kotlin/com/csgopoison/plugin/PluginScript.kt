package com.csgopoison.plugin

import com.csgopoison.*
import com.csgopoison.input.UserInput
import kotlin.reflect.jvm.reflect
import kotlin.script.experimental.annotations.KotlinScript

@KotlinScript(
	"CSGOPoison",
	fileExtension = "csgopoison.kts",
	filePathPattern = "",
	compilationConfiguration = PluginScriptCompilation::class
)
abstract class PluginScript(
	val csgo: CSGO,
	val app: Overlay,
	val input: UserInput
	) : CSGOContext by csgo {

	//TODO move this to a better spot, so that each script wont need to reinit... perhaps expand csgocontext

	fun draw(body: DrawContext.() -> Unit, precheck: DrawContext.() -> Boolean = {true}) {
		app.renderHook(body, precheck)
	}

	inline fun forEntities(entityTypes: Array<EntityType>, crossinline body: (EntityData) -> Unit) {
		entityManager.allEntities.forEach { entityData ->

			//println("entityTypes: " + entityTypes.joinToString() + " entity: " + entityData.entityType)

			if (entityTypes.contains(entityData.entityType)) {
				//println("running entityData with type: " + entityData.entityType)
				entityData.run(body)
			}
		}
	}
}