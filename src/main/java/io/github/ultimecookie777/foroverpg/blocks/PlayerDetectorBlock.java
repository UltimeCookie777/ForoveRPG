package io.github.ultimecookie777.foroverpg.blocks;

import com.google.common.collect.ImmutableMap;
import io.github.ultimecookie777.foroverpg.blockentities.PlayerDetectorBlockEntity;
import io.github.ultimecookie777.foroverpg.init.BlockEntityInit;
import io.github.ultimecookie777.foroverpg.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;


public class PlayerDetectorBlock extends Block implements EntityBlock {

    protected static final VoxelShape BOX = Block.box(2,1,2,16,16,16);

    public PlayerDetectorBlock(Properties prop) {
        super(prop);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    protected ImmutableMap<BlockState, VoxelShape> getShapeForEachState(Function<BlockState, VoxelShape> p_152459_) {
        return ImmutableMap.of(BlockInit.PLAYER_DETECTOR_BLOCK.get().defaultBlockState(), BOX);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level p_153212_, @NotNull BlockState p_153213_, @NotNull BlockEntityType<T> type) {
        return type == BlockEntityInit.PLAYER_DETECTOR_BLOCK_ENTITY.get() ? PlayerDetectorBlockEntity::tick : null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return BlockEntityInit.PLAYER_DETECTOR_BLOCK_ENTITY.get().create(pos, state);
    }



}
