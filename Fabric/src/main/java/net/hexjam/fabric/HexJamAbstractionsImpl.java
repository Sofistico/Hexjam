package net.hexjam.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.hexjam.HexJamAbstractions;

import java.nio.file.Path;

public class HexJamAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexJamAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
