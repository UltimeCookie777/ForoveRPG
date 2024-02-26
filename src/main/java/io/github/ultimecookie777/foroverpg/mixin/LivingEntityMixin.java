package io.github.ultimecookie777.foroverpg.mixin;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "makePoofParticles", at=@At("HEAD"), cancellable = true)
    public void makePoofParticlesInject(CallbackInfo ci) {

        ci.cancel();

    }

}
