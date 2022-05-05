package com.csgopoison.plugins.boxesp

import com.csgopoison.settings.*

enum class BoxFlags(val enabled: Boolean, val pos: PosFlags) {
    NAME(BOX_ESP_NAME, PosFlags.fromInt(BOX_ESP_NAME_POS)), HEALTH(BOX_HEALTH, PosFlags.fromInt(BOX_HEALTH_POS)),
    ARMOR(BOX_ARMOR, PosFlags.fromInt(BOX_ARMOR_POS)), WEAPON(BOX_WEAPON, PosFlags.fromInt(BOX_WEAPON_POS)),
    AMMO(BOX_AMMO, PosFlags.fromInt(BOX_AMMO_POS)), MONEY(BOX_MONEY, PosFlags.fromInt(BOX_MONEY_POS)),
    HELMET(BOX_HELMET, PosFlags.fromInt(BOX_HELMET_POS)), KEVLAR(BOX_KEVLAR, PosFlags.fromInt(BOX_KEVLAR_POS)),
    SCOPED(BOX_SCOPED, PosFlags.fromInt(BOX_SCOPED_POS)), FLASHED(BOX_FLASHED, PosFlags.fromInt(BOX_FLASHED_POS));

    companion object {
        val ALL: MutableList<BoxFlags> = values().toMutableList()
    }
}