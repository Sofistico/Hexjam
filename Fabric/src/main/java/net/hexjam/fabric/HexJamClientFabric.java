package net.hexjam.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.hexjam.HexJamClient;

/**
 * Fabric client loading entrypoint.
 */
public class HexJamClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HexJamClient.init();
    }
}
