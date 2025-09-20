package the64thgamer.no_m

import item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object NoM : ModInitializer {
    public val MOD_ID = "no_m"
    public val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
        ModItems.registerModItems()
	}
}