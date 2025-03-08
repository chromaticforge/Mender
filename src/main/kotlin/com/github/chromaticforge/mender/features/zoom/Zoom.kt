package com.github.chromaticforge.mender.features.zoom

import net.minecraft.client.Minecraft

object Zoom {
    var enabled = false
    var prevSmoothCamera = Minecraft.getMinecraft().gameSettings.smoothCamera
}