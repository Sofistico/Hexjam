package net.hexjam.registry;

import at.petrak.hexcasting.api.PatternRegistry;
import at.petrak.hexcasting.api.misc.MediaConstants;
import at.petrak.hexcasting.api.spell.Action;
import at.petrak.hexcasting.api.spell.math.HexDir;
import at.petrak.hexcasting.api.spell.math.HexPattern;
import at.petrak.hexcasting.api.utils.MediaHelper;
import at.petrak.hexcasting.common.casting.operators.spells.OpPotionEffect;
import kotlin.Triple;
import net.hexjam.casting.patterns.math.OpSignum;
import net.hexjam.casting.patterns.spells.OpCongrats;
import net.hexjam.casting.patterns.spells.OpShears;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.hexjam.casting.*;

import java.util.ArrayList;
import java.util.List;

import static net.hexjam.HexJam.id;

public class HexJamPatternRegistry {
    public static List<Triple<HexPattern, Identifier, Action>> PATTERNS = new ArrayList<>();
    public static List<Triple<HexPattern, Identifier, Action>> PER_WORLD_PATTERNS = new ArrayList<>();
    // IMPORTANT: be careful to keep the registration calls looking like this, or you'll have to edit the hexdoc pattern regex.
    public static HexPattern CONGRATS = registerPerWorld(HexPattern.fromAngles("eed", HexDir.WEST), "congrats", new OpCongrats());
    public static HexPattern SIGNUM = register(HexPattern.fromAngles("edd", HexDir.NORTH_WEST), "signum", new OpSignum());
    public static HexPattern SHEARS = register(HexPattern.fromAngles("eed", HexDir.WEST), "shears", new OpShears());
    public static HexPattern HUNGER = register(HexPattern.fromAngles("aqqqqqeawaw", HexDir.NORTH_WEST), "potion/hunger", new OpPotionEffect(StatusEffects.HUNGER, MediaConstants.DUST_UNIT, true, false, false));

    public static void init() {
        try {
            for (Triple<HexPattern, Identifier, Action> patternTriple : PATTERNS) {
                PatternRegistry.mapPattern(patternTriple.getFirst(), patternTriple.getSecond(), patternTriple.getThird());
            }
            for (Triple<HexPattern, Identifier, Action> patternTriple : PER_WORLD_PATTERNS) {
                PatternRegistry.mapPattern(patternTriple.getFirst(), patternTriple.getSecond(), patternTriple.getThird(), true);
            }
        } catch (PatternRegistry.RegisterPatternException e) {
            e.printStackTrace();
        }
    }

    private static HexPattern register(HexPattern pattern, String name, Action action) {
        Triple<HexPattern, Identifier, Action> triple = new Triple<>(pattern, id(name), action);
        PATTERNS.add(triple);
        return pattern;
    }

    private static HexPattern registerPerWorld(HexPattern pattern, String name, Action action) {
        Triple<HexPattern, Identifier, Action> triple = new Triple<>(pattern, id(name), action);
        PER_WORLD_PATTERNS.add(triple);
        return pattern;
    }
}
