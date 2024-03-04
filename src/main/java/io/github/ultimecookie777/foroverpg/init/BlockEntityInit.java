package io.github.ultimecookie777.foroverpg.init;

import io.github.ultimecookie777.foroverpg.ForoveRPG;
import io.github.ultimecookie777.foroverpg.blockentities.PlayerDetectorBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityInit {


    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTER = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ForoveRPG.MODID);

    public static final Supplier<BlockEntityType<PlayerDetectorBlockEntity>> PLAYER_DETECTOR_BLOCK_ENTITY = BLOCK_ENTITY_REGISTER.register("player_detector_entity", () ->
            BlockEntityType.Builder.of(PlayerDetectorBlockEntity::new, BlockInit.PLAYER_DETECTOR_BLOCK.get()).build(null));




}
