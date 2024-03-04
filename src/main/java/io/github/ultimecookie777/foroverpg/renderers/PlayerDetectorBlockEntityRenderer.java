package io.github.ultimecookie777.foroverpg.renderers;

import io.github.ultimecookie777.foroverpg.blockentities.PlayerDetectorBlockEntity;
import io.github.ultimecookie777.foroverpg.geomodels.block.PlayerDetectorModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PlayerDetectorBlockEntityRenderer extends GeoBlockRenderer<PlayerDetectorBlockEntity> {
    public PlayerDetectorBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(new PlayerDetectorModel());
    }
}
