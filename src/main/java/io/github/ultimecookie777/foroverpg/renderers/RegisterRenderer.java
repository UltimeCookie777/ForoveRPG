package io.github.ultimecookie777.foroverpg.renderers;

import io.github.ultimecookie777.foroverpg.init.BlockEntityInit;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class RegisterRenderer {

    @SubscribeEvent
    public static void blockEntityRendererRegister(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntityInit.PLAYER_DETECTOR_BLOCK_ENTITY.get(), PlayerDetectorBlockEntityRenderer::new);
    }
}
