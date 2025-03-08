package com.github.chromaticforge.mender.mixins;

import com.github.chromaticforge.mender.config.MenderConfig;
import com.github.chromaticforge.mender.features.zoom.Zoom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer_Zoom {
    @Shadow private Minecraft mc;

    @Inject(method = "getFOVModifier", at = @At("RETURN"), cancellable = true)
    private void zoom(float partialTicks, boolean useFOVSetting, CallbackInfoReturnable<Float> cir) {
        boolean flag = MenderConfig.INSTANCE.getZoomBind().isActive();

        if (flag) {
            if (!Zoom.INSTANCE.getEnabled()) {
                Zoom.INSTANCE.setEnabled(true);
                Zoom.INSTANCE.setPrevSmoothCamera(mc.gameSettings.smoothCamera);
                mc.gameSettings.smoothCamera = true;
                mc.renderGlobal.setDisplayListEntitiesDirty();
            } else {
                cir.setReturnValue(cir.getReturnValue() / 4.0f);
            }
        } else {
            Zoom.INSTANCE.setEnabled(false);
            mc.gameSettings.smoothCamera = Zoom.INSTANCE.getPrevSmoothCamera();
            mc.renderGlobal.setDisplayListEntitiesDirty();
        }
    }
}
