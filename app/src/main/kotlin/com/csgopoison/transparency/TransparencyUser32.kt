package com.csgopoison.transparency

import org.jire.gamepoison.jna.DirectNativeLibrary

object TransparencyUser32 : DirectNativeLibrary("user32") {
    @JvmStatic
    external fun SetWindowCompositionAttribute(hwnd: Long, data: WindowsCompositionAttributeData): Long
}