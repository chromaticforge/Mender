package com.github.chromaticforge.mender.features.gui.pages.api

import com.github.chromaticforge.mender.features.gui.Pages
import net.minecraft.client.gui.GuiButton

abstract class Option(val page: Pages) {
    val buttonList: List<GuiButton> = ArrayList()

    abstract fun draw(x: Int, y: Int, pt: Float)
}