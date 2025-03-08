package com.github.chromaticforge.mender.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(GameSettings.class)
public class MixinGameSettings_ExtendedRenderDistance {
    @Inject(method = "<init>(Lnet/minecraft/client/Minecraft;Ljava/io/File;)V", at = @At("RETURN"))
    public void extendRenderDistance(Minecraft mcIn, File p_i46326_2_, CallbackInfo ci) {
        GameSettings.Options.RENDER_DISTANCE.setValueMax(64.0f);
    }

}
