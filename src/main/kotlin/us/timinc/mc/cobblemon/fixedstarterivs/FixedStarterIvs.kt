package us.timinc.mc.cobblemon.fixedstarterivs

import com.cobblemon.mod.common.api.events.CobblemonEvents
import net.fabricmc.api.ModInitializer
import us.timinc.mc.cobblemon.fixedstarterivs.config.Config
import us.timinc.mc.cobblemon.fixedstarterivs.config.ConfigBuilder

object FixedStarterIvs : ModInitializer {
    @Suppress("MemberVisibilityCanBePrivate")
    const val MOD_ID = "fixedstarterivs"
    private val config: Config = ConfigBuilder.load(Config::class.java, MOD_ID)

    override fun onInitialize() {
        CobblemonEvents.STARTER_CHOSEN.subscribe { event ->
            event.pokemon.ivs.forEach { (stat, _) ->
                event.pokemon.ivs[stat] = config.fixedIvValue
            }
        }
    }
}