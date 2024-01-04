package net.hexjam.forge;

import dev.architectury.platform.forge.EventBuses;
import net.hexjam.HexJam;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(HexJam.MOD_ID)
public class HexJamForge {
    public HexJamForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(HexJam.MOD_ID, bus);
        bus.addListener(HexJamClientForge::init);
        HexJam.init();
    }
}
