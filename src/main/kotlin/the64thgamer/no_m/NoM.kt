package the64thgamer.no_m

import block.ModBlocks
import item.ModItems
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.player.AttackEntityCallback
import net.minecraft.entity.mob.CreeperEntity
import net.minecraft.util.ActionResult
import org.slf4j.LoggerFactory
import the64thgamer.no_m.ForceExplodable
import kotlin.random.Random

object NoM : ModInitializer {
    public val MOD_ID = "no_m"
    public val logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        ModItems.registerModItems()
        ModBlocks.registerModBlocks()
        registerCreeperHitEvent()
    }

    fun registerCreeperHitEvent() {
        AttackEntityCallback.EVENT.register { player, world, hand, entity, hitResult ->
            if (entity is CreeperEntity && Random.nextFloat() <= 0.25f) {
                (entity as ForceExplodable).triggerForceExplosion(entity)
            }
            ActionResult.PASS
        }
    }
}