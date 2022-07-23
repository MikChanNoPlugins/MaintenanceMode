package dev.mikchan.mcnp.maintenance.formatter

import me.clip.placeholderapi.PlaceholderAPIPlugin
import org.bukkit.plugin.java.JavaPlugin

internal class FormatterCreator {
    fun build(plugin: JavaPlugin): IFormatter {
        val papi = plugin.server.pluginManager.getPlugin("PlaceholderAPI") as? PlaceholderAPIPlugin
        if (papi != null) {
            plugin.logger.info("Found PlaceholderAPI. Hooking...")
            return PapiFormatter()
        }

        return DefaultFormatter()
    }
}
