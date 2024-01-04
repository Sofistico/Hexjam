package net.hexjam;

import net.hexjam.registry.HexJamIotaTypeRegistry;
import net.hexjam.registry.HexJamItemRegistry;
import net.hexjam.registry.HexJamPatternRegistry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class HexJam {
    public static final String MOD_ID = "hexjam";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
        LOGGER.info("HexJam says hello!");

        HexJamItemRegistry.init();
        HexJamIotaTypeRegistry.init();
        HexJamPatternRegistry.init();

        LOGGER.info(HexJamAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static Identifier id(String string) {
        return new Identifier(MOD_ID, string);
    }
}
