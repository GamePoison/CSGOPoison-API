package com.csgopoison

import com.csgopoison.CSGOState.csgo

val emptyEntity = csgo.entity(0)

data class EntityData(  var entityAddress: Long = -1, var entity: Entity = emptyEntity, var glowAddress: Long = -1,
                        var glowIndex: Long = -1, var entityType: EntityType = EntityType.NULL) {

    fun set(entityAddress: Long, entity: Entity, glowAddress: Long, glowIndex: Long, entityType: EntityType) {
        this.entityAddress = entityAddress
        this.entity = entity
        this.glowAddress = glowAddress
        this.glowIndex = glowIndex
        this.entityType = entityType
    }
}
