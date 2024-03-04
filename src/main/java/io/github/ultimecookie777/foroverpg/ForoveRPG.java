package io.github.ultimecookie777.foroverpg;

import com.mojang.logging.LogUtils;
import io.github.ultimecookie777.foroverpg.effects.DeathParticle;
import io.github.ultimecookie777.foroverpg.init.BlockEntityInit;
import io.github.ultimecookie777.foroverpg.init.BlockInit;
import io.github.ultimecookie777.foroverpg.renderers.RegisterRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

@Mod(ForoveRPG.MODID)
public class ForoveRPG
{
    public static final String MODID = "foroverpg";

    public static final Logger LOGGER = LogUtils.getLogger();


    public ForoveRPG(IEventBus modEventBus)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        BlockInit.BLOCK_REGISTER.register(modEventBus);
        BlockEntityInit.BLOCK_ENTITY_REGISTER.register(modEventBus);

        NeoForge.EVENT_BUS.register(new DeathParticle());

        NeoForge.EVENT_BUS.register(this);

        NeoForge.EVENT_BUS.register(new EventHandler());

        modEventBus.register(RegisterRenderer.class);

        GeckoLib.initialize(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
