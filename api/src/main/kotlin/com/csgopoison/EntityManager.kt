package com.csgopoison

import java.util.concurrent.CopyOnWriteArrayList

interface EntityManager {
    val allEntities: CopyOnWriteArrayList<EntityData>

    val meAddress: Long
    val me: Player
    val clientState: ClientState

    fun updateEntities(): Boolean
}