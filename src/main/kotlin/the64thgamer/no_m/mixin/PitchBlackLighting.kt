package the64thgamer.no_m.mixin

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.client.render.LightmapTextureManager
import net.minecraft.client.gl.ShaderProgram
import net.minecraft.client.MinecraftClient
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import java.lang.reflect.Field

@Environment(EnvType.CLIENT)
@Mixin(LightmapTextureManager::class)
abstract class PitchBlackLighting {

    @Inject(method = ["update"], at = [At("TAIL")])
    private fun onLightmapUpdate(ci: CallbackInfo) {
        try {
            // get the native image field that stores brightness lookup
            val imageField: Field = LightmapTextureManager::class.java.getDeclaredField("image")
            imageField.isAccessible = true
            val image = imageField.get(this) as net.minecraft.client.texture.NativeImage

            if (image != null) {
                // Make the bottom-left pixel (0,0) fully black
                image.setColor(0, 0, 0xFF000000.toInt())

                // Possibly set the entire column blockLight = 0 to black
                for (sky in 0 until image.height) {
                    image.setColor(0, sky, 0xFF000000.toInt())
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
