package com.github.chromaticforge.mender.mixins;
import com.github.chromaticforge.mender.features.gui.OptionsGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.settings.GameSettings;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiOptions.class)
public class MixinGuiOptions_SettingsGui {
    @Shadow @Final private GameSettings game_settings_1;

    @ModifyConstant(
            method = "initGui",
            constant = @Constant(intValue = 101)
    )
    private int buttonId(int constant) {
        return 9999;
    }

    @Inject(
            method = "actionPerformed",
            at = @At("TAIL")
    )
    private void openGui(GuiButton button, CallbackInfo ci) {
        if (button.id == 9999) {
            Minecraft.getMinecraft().displayGuiScreen(new OptionsGui((GuiOptions)(Object)this, game_settings_1));
        }
    }
}
