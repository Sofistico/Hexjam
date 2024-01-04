package net.hexjam.forge;

import net.hexjam.HexJamClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class HexJamClientForge {
    public static void init(FMLClientSetupEvent event) {
        HexJamClient.init();
    }
}
