package net.hexjam.casting.patterns.math

import at.petrak.hexcasting.api.spell.ConstMediaAction
import at.petrak.hexcasting.api.spell.RenderedSpell
import at.petrak.hexcasting.api.spell.casting.CastingContext
import at.petrak.hexcasting.api.spell.iota.Iota
import at.petrak.hexcasting.api.spell.getPlayer

class OpHungerLevel : ConstMediaAction {
    override val argc: Int
        get() = 0

    override fun execute(args: List<Iota>, ctx: CastingContext): List<Iota> {
        val player = args.getPlayer(0, argc)
    }

    private data class HungerLevel(val PlayerEntity: player) : RenderedSpell{
        override fun cast(ctx: CastingContext) {
            TODO("Not yet implemented")
        }

    }
}