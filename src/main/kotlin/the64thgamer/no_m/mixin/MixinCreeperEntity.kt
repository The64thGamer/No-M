package the64thgamer.no_m.mixin

import net.minecraft.entity.mob.CreeperEntity
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.Unique
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import the64thgamer.no_m.ForceExplodable

@Mixin(CreeperEntity::class)
abstract class MixinCreeperEntity : ForceExplodable {

    @Unique private var forceExplosion: Boolean = false

    override fun triggerForceExplosion(creeper: CreeperEntity) {
        forceExplosion = true
        creeper.ignite()
        creeper.setFuseSpeed(1)

        // Force fuse time to "done"
        val field = CreeperEntity::class.java.getDeclaredField("currentFuseTime")
        field.isAccessible = true
    }

    @Inject(method = ["explode"], at = [At("HEAD")], cancellable = true)
    fun preventExplosion(ci: CallbackInfo) {
        if (!forceExplosion) {
            ci.cancel()
        }
        forceExplosion = false
    }
}
