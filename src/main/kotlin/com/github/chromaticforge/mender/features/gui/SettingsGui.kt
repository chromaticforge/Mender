package com.github.chromaticforge.mender.features.gui

import net.minecraft.client.gui.GuiButton
import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.gui.GuiVideoSettings
import net.minecraft.client.settings.GameSettings
import org.lwjgl.input.Keyboard

class SettingsGui(private val origin: GuiScreen, private val gameSettings: GameSettings) : GuiScreen() {
    override fun initGui() {
        buttonList.clear()
        buttonList.add(GuiButton(1, 3, 3, "Hello World!"))
    }

    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        drawDefaultBackground()
        drawCenteredString(fontRendererObj, "Press LSHIFT + P to open Vanilla video settings", this.width / 2, 15, 0xffffff)
        super.drawScreen(mouseX, mouseY, partialTicks)
    }

    override fun handleKeyboardInput() {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && Keyboard.isKeyDown(Keyboard.KEY_P)) {
            mc.displayGuiScreen(GuiVideoSettings(this, gameSettings))
        }
        super.handleKeyboardInput()
    }


    override fun doesGuiPauseGame(): Boolean {
        return true
    }
}