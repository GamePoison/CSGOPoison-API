package com.csgopoison

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.ScreenUtils
import com.csgopoison.transparency.AccentFlags
import com.csgopoison.transparency.AccentStates
import com.csgopoison.transparency.TransparencyUser32
import com.csgopoison.transparency.WindowsCompositionAttributeData
import com.sun.jna.platform.win32.WinUser
import it.unimi.dsi.fastutil.objects.ObjectArrayList
import it.unimi.dsi.fastutil.objects.ObjectList
import org.gamepoison.native.jna.windows.User32
import org.lwjgl.glfw.GLFW
import org.lwjgl.system.windows.User32.*
import java.lang.Integer.min
import java.util.concurrent.ThreadLocalRandom

//Add context(s) used by PluginScript's draw {} here...
interface DrawContext {
    val gameContext: CSGOContext
    val camera: OrthographicCamera
    val shapes: ShapeRenderer
}

interface IOverlay {
    val gameContext: CSGOContext
}

open class Overlay(
    override val gameContext: CSGOContext,
    val title: String = ThreadLocalRandom.current().nextLong().toString()
): IOverlay, ApplicationAdapter() {
    open val myHWND: Long = 0

    open val camera: OrthographicCamera? = null
    open val shapes: ShapeRenderer? = null

    open var renderHooks: ObjectList<Pair<DrawContext.() -> Unit, DrawContext.() -> Boolean>> = ObjectArrayList()

    fun renderHook(body: DrawContext.() -> Unit, precheck: DrawContext.() -> Boolean) {
        renderHooks.add(Pair(body, precheck))
    }

    override fun render() {}

    open fun createRenderComponents() {}
    open fun configureRendering() {}

    open fun open(openHook: DrawContext.() -> Unit): Lwjgl3Application {return Lwjgl3Application(this, Lwjgl3ApplicationConfiguration())}

    open fun makeTransparent(myHWND: Long): Long { return -0L }
    open fun makeUndecorated(myHWND: Long): Int { return -0 }
    open fun makeClickthrough(myHWND: Long): Int { return -0 }
}