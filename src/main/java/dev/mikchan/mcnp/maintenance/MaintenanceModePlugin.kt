package dev.mikchan.mcnp.maintenance

import dev.mikchan.mcnp.maintenance.command.AdminCommand
import dev.mikchan.mcnp.maintenance.config.Config
import dev.mikchan.mcnp.maintenance.config.IConfig
import dev.mikchan.mcnp.maintenance.config.IConfigListener
import dev.mikchan.mcnp.maintenance.listener.MainListener
import org.bstats.bukkit.Metrics
import org.bukkit.event.HandlerList
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class MaintenanceModePlugin : JavaPlugin(), IConfigListener {
    companion object {
        private const val bStatsId = 15889
    }

    private val config = Config(this)
    private var stateEnabled = false

    private fun enable() {
        if (stateEnabled) return
        stateEnabled = true

        for (player in server.onlinePlayers) {
            if (player.hasPermission("mcn.maintenance.allow")) continue
            player.kickPlayer(config.kickMessage)
        }

        server.pluginManager.registerEvents(MainListener(config), this)
    }

    private fun disable() {
        if (!stateEnabled) return
        stateEnabled = false

        HandlerList.unregisterAll(this)
    }

    override fun handleUpdate(config: IConfig) {
        if (config.enabled) enable()
        else disable()
    }

    override fun onEnable() {
        saveDefaultConfig()
        if (config.enabled) enable()
        config.subscribe(this)

        getCommand("mcn_maintenance")?.let {
            val adminCommand = AdminCommand(config)
            it.setExecutor(adminCommand)
            it.tabCompleter = adminCommand
        }

        Metrics(this, bStatsId)
    }

    override fun onDisable() {
        disable()
        getCommand("mcn_maintenance")?.let {
            it.setExecutor(null)
            it.tabCompleter = null
        }
    }
}
