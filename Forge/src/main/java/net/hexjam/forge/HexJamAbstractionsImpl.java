package net.hexjam.forge;

import net.hexjam.HexJamAbstractions;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class HexJamAbstractionsImpl {
    /**
     * This is the actual implementation of {@link HexJamAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
