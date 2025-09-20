package the64thgamer.no_m

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object NoM : ModInitializer {
    private val MOD_ID = "No M"
    private val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		logger.info("Hello Fabric world!")
	}
}