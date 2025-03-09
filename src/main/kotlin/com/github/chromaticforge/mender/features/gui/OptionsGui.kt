package com.github.chromaticforge.mender.features.gui

import com.github.chromaticforge.mender.features.gui.pages.*
import com.github.chromaticforge.mender.features.gui.pages.api.Option
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiButton
import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.gui.GuiVideoSettings
import net.minecraft.client.gui.ScaledResolution
import net.minecraft.client.settings.GameSettings
import org.lwjgl.input.Keyboard

class OptionsGui(private val origin: GuiScreen, private val gameSettings: GameSettings) : GuiScreen() {
    private lateinit var scaledResolution: ScaledResolution

    private lateinit var video: GuiButton
    private lateinit var quality: GuiButton
    private lateinit var details: GuiButton
    private lateinit var performance: GuiButton
    private lateinit var animations: GuiButton
    private lateinit var shaders: GuiButton
    private lateinit var advanced: GuiButton

    private var currentPage: Option = VideoOptions()

    override fun initGui() {
        scaledResolution = ScaledResolution(mc)
        buttonList.clear()
        // Video, Quality, Details, Performance, Animations, Shaders, Advanced
        var x = 6
        var width = fontRendererObj.getStringWidth("Video")
        video = GuiButton(101, x, 6, width + 20, 20, "Video")
        x += video.width + 6
        width = fontRendererObj.getStringWidth("Quality")
        quality = GuiButton(102, x, 6, width + 20, 20, "Quality")
        x += quality.width + 6
        width = fontRendererObj.getStringWidth("Details")
        details = GuiButton(103, x, 6, width + 20, 20, "Details")
        x += details.width + 6
        width = fontRendererObj.getStringWidth("Performance")
        performance = GuiButton(104, x, 6, width + 20, 20,"Performance")
        x += performance.width + 6
        width = fontRendererObj.getStringWidth("Animations")
        animations = GuiButton(105, x, 6, width + 20, 20,"Animations")
        x += animations.width + 6
        width = fontRendererObj.getStringWidth("Shaders")
        shaders = GuiButton(106, x, 6, width + 20, 20,"Shaders")
        x += shaders.width + 6
        width = fontRendererObj.getStringWidth("Advanced")
        advanced = GuiButton(107, x, 6, width + 20, 20,"Advanced")

        buttonList.plusAssign(listOf(video, quality, details, performance, animations, shaders, advanced))
    }

    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        drawDefaultBackground()

        currentPage.draw(mouseX, mouseY, partialTicks)

        fontRendererObj.drawStringWithShadow("Shift + P for vanilla options!", 6f, scaledResolution.scaledHeight - 12f, 0x828282)

        super.drawScreen(mouseX, mouseY, partialTicks)
    }

    override fun actionPerformed(button: GuiButton) {
        if (button.enabled) {
            when (button.id) {
                video.id -> {
                    enableButtons()
                    video.enabled = false
                    currentPage = VideoOptions()
                }
                quality.id -> {
                    enableButtons()
                    quality.enabled = false
                    currentPage = QualityOptions()
                }
                details.id -> {
                    enableButtons()
                    details.enabled = false
                    currentPage = DetailOptions()
                }
                performance.id -> {
                    enableButtons()
                    performance.enabled = false
                    currentPage = PerformanceOptions()
                }
                animations.id -> {
                    enableButtons()
                    animations.enabled = false
                    currentPage = AnimationOptions()
                }
                shaders.id -> {
                    enableButtons()
                    shaders.enabled = false
                    currentPage = ShaderOptions()
                }
                advanced.id -> {
                    enableButtons()
                    advanced.enabled = false
                    currentPage = AdvancedOptions()
                }
            }
        }

        super.actionPerformed(button)
    }

    fun enableButtons() {
        video.enabled = true
        quality.enabled = true
        details.enabled = true
        performance.enabled = true
        animations.enabled = true
        shaders.enabled = true
        advanced.enabled = true
    }

    override fun handleKeyboardInput() {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && Keyboard.isKeyDown(Keyboard.KEY_P)) {
            mc.displayGuiScreen(GuiVideoSettings(this, gameSettings))
        }
        super.handleKeyboardInput()
    }

    override fun onResize(mcIn: Minecraft, w: Int, h: Int) {
        scaledResolution = ScaledResolution(mc)
        super.onResize(mcIn, w, h)
    }

    override fun doesGuiPauseGame(): Boolean {
        return true
    }
}