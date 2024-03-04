package io.github.ultimecookie777.foroverpg.blockentities;

import com.mojang.logging.LogUtils;
import io.github.ultimecookie777.foroverpg.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PlayerDetectorBlockEntity extends BlockEntity implements GeoBlockEntity {

    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.playerdetector.idle");
    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final int TICKS_PER_TICK = 5;
    public static final double DISTANCE = 10;

    private static int tickPassed = 0;

    public PlayerDetectorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.PLAYER_DETECTOR_BLOCK_ENTITY.get(), pos, state);
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {

        if (level.isClientSide()) {
            return;
        }

        tickPassed++;

        // tick every 5 ticks
        if (tickPassed == TICKS_PER_TICK) {
            tickPassed = 0;

            level.players().forEach(player -> {

                Vec3 playerPos = player.getPosition(1f);

                double distance = playerPos.distanceTo(blockPos.getCenter());

                if (distance <= DISTANCE) {

                    //player.kill();
                    LOGGER.info("TRUE");

                }

            });

        }

    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
            new AnimationController<>(this, this::deployAnimController)
        );
    }

    protected <E extends PlayerDetectorBlockEntity> PlayState deployAnimController(final AnimationState<E> state) {
        return state.setAndContinue(IDLE);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.animatableInstanceCache;
    }
}
