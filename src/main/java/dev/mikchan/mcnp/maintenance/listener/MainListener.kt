package dev.mikchan.mcnp.maintenance.listener

import dev.mikchan.mcnp.maintenance.config.IConfig
import dev.mikchan.mcnp.maintenance.formatter.IFormatter
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerLoginEvent
import org.bukkit.event.server.ServerListPingEvent

internal class MainListener(private val config: IConfig, private val formatter: IFormatter) : Listener {
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun onAsyncPlayerPreLogin(event: PlayerLoginEvent) {
        if (event.player.hasPermission("mcn.maintenance.allow")) return
        event.disallow(PlayerLoginEvent.Result.KICK_OTHER, formatter.format(config.kickMessage, event.player))
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun onServerListPing(event: ServerListPingEvent) {
        if (!config.enableCustomMotd) return
        event.motd = formatter.format(config.customMotd, null)
    }
}
