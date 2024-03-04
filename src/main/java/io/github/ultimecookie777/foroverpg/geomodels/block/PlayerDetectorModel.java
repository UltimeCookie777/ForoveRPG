package io.github.ultimecookie777.foroverpg.geomodels.block;

import io.github.ultimecookie777.foroverpg.ForoveRPG;
import io.github.ultimecookie777.foroverpg.blockentities.PlayerDetectorBlockEntity;
import io.github.ultimecookie777.foroverpg.blocks.PlayerDetectorBlock;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class PlayerDetectorModel extends GeoModel<PlayerDetectorBlockEntity> {

    private final ResourceLocation MODEL = new ResourceLocation(ForoveRPG.MODID, "geo/player_detector.geo.json");
    private final ResourceLocation TEXTURE = new ResourceLocation(ForoveRPG.MODID, "textures/block/player_detector.png");
    private final ResourceLocation ANIMATION = new ResourceLocation(ForoveRPG.MODID, "animations/player_detector.animation.json");

    @Override
    public ResourceLocation getModelResource(PlayerDetectorBlockEntity playerDetectorBlockEntity) {
        return this.MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(PlayerDetectorBlockEntity playerDetectorBlockEntity) {
        return this.TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationResource(PlayerDetectorBlockEntity playerDetectorBlockEntity) {
        return this.ANIMATION;
    }


}
