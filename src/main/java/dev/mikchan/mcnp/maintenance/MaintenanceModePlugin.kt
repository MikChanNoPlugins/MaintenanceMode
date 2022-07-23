package dev.mikchan.mcnp.maintenance

import dev.mikchan.mcnp.maintenance.command.AdminCommand
import dev.mikchan.mcnp.maintenance.config.Config
import dev.mikchan.mcnp.maintenance.config.IConfig
import dev.mikchan.mcnp.maintenance.config.IConfigListener
import dev.mikchan.mcnp.maintenance.formatter.FormatterCreator
import dev.mikchan.mcnp.maintenance.listener.MainListener
import org.bstats.bukkit.Metrics
import org.bukkit.event.HandlerList
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class MaintenanceModePlugin : JavaPlugin(), IConfigListener {
    companion object {
        private const val bStatsId = 15889
    }

    private var stateEnabled = false

    private fun enable(config: IConfig) {
        if (stateEnabled) return
        stateEnabled = true

        val formatter = FormatterCreator().build(this)
        server.pluginManager.registerEvents(MainListener(config, formatter), this)

        for (player in server.onlinePlayers) {
            if (player.hasPermission("mcn.maintenance.allow")) continue
            player.kickPlayer(formatter.format(config.kickMessage, player))
        }
    }

    private fun disable() {
        if (!stateEnabled) return
        stateEnabled = false

        HandlerList.unregisterAll(this)
    }

    override fun handleUpdate(config: IConfig) {
        if (config.enabled) enable(config)
        else disable()
    }

    override fun onEnable() {
        saveDefaultConfig()
        val config = Config(this)

        if (config.enabled) enable(config)
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
