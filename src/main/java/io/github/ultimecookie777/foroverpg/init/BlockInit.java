package io.github.ultimecookie777.foroverpg.init;

import io.github.ultimecookie777.foroverpg.ForoveRPG;
import io.github.ultimecookie777.foroverpg.blocks.PlayerDetectorBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockInit {

    public static final DeferredRegister.Blocks BLOCK_REGISTER = DeferredRegister.createBlocks(ForoveRPG.MODID);

    public static final DeferredBlock<PlayerDetectorBlock> PLAYER_DETECTOR_BLOCK = BLOCK_REGISTER.register("player_detector", () -> new PlayerDetectorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANVIL).noOcclusion()));

}
