package com.github.chromaticforge.mender.config

import cc.polyfrost.oneconfig.config.Config
import cc.polyfrost.oneconfig.config.annotations.KeyBind
import cc.polyfrost.oneconfig.config.core.OneKeyBind
import cc.polyfrost.oneconfig.config.data.Mod
import cc.polyfrost.oneconfig.config.data.ModType
import cc.polyfrost.oneconfig.libs.universal.UKeyboard
import com.github.chromaticforge.mender.MenderMod

object MenderConfig : Config(Mod(MenderMod.NAME, ModType.UTIL_QOL), "${MenderMod.MODID}.json") {
    init {
        initialize()
    }

    @KeyBind(name = "Zoom")
    var zoomBind = OneKeyBind(UKeyboard.KEY_C)
}