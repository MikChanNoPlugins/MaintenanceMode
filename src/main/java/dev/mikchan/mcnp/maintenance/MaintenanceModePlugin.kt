package dev.mikchan.mcnp.maintenance

import org.bstats.bukkit.Metrics
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class MaintenanceModePlugin : JavaPlugin() {
    companion object {
        private const val bStatsId = 15889
    }

    override fun onEnable() {
        Metrics(this, bStatsId)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
