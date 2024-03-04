package io.github.ultimecookie777.foroverpg;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = ForoveRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER  = new ModConfigSpec.Builder();

    private static final ModConfigSpec.IntValue MAX_MANA = BUILDER
            .comment("Max default Mana value")
            .defineInRange("maxMana", 100, 0, Integer.MAX_VALUE);

    @SuppressWarnings("unused")
    private static final ModConfigSpec.IntValue COMMON_RARITY = BUILDER
            .comment("Default common rarity")
            .defineInRange("commonRarity", 50, 0, 100);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static int maxMana;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent evvent) {

        maxMana = MAX_MANA.get();

    }
}
