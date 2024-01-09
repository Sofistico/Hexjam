package net.hexjam.casting.patterns.spells

import at.petrak.hexcasting.api.spell.ParticleSpray
import at.petrak.hexcasting.api.spell.RenderedSpell
import at.petrak.hexcasting.api.spell.SpellAction
import at.petrak.hexcasting.api.spell.casting.CastingContext
import at.petrak.hexcasting.api.spell.iota.Iota
import at.petrak.hexcasting.api.spell.getPlayer
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack

class OpEatFood : SpellAction {
    override val argc: Int
        get() = 1

    override fun execute(args: List<Iota>, ctx: CastingContext):
            Triple<RenderedSpell, Int, List<ParticleSpray>>? {
        TODO("Not yet implemented")
    }
    private data class EatFood(val entity: PlayerEntity, val eatableStack: ItemStack)
        : RenderedSpell{
        override fun cast(ctx: CastingContext) {
            if(entity.hungerManager.isNotFull)
                entity.eatFood(ctx.world, eatableStack)
        }

    }
}