package com.github.chromaticforge.mender

import com.github.chromaticforge.mender.config.MenderConfig
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(
    modid = MenderMod.MODID,
    name = MenderMod.NAME,
    version = MenderMod.VERSION,
    modLanguageAdapter = "cc.polyfrost.oneconfig.utils.KotlinLanguageAdapter"
)
object MenderMod {
    const val MODID: String = "@ID@"
    const val NAME: String = "@NAME@"
    const val VERSION: String = "@VER@"

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        MenderConfig
    }
}
