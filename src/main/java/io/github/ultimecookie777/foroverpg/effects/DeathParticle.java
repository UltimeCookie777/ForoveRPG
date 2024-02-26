package io.github.ultimecookie777.foroverpg.effects;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import org.joml.Vector3f;

public class DeathParticle {

    @SubscribeEvent
    public void livingDeathEvent(LivingDeathEvent event) {

        LivingEntity entity = event.getEntity();

        Level level = entity.level();

        level.addParticle(new DustParticleOptions(new Vector3f(1f, 0f, 0f), 4f), entity.position().x(), entity.position().y() + 1f, entity.position().z, 0, 2f, 0);

        level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.REDSTONE_BLOCK.defaultBlockState()), entity.position().x() + 1f, entity.position().y(), entity.position().z(), 0, 1f, 0);

    }



}