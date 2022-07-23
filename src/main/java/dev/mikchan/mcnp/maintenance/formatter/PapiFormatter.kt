package dev.mikchan.mcnp.maintenance.formatter

import me.clip.placeholderapi.PlaceholderAPI
import net.md_5.bungee.api.ChatColor
import org.bukkit.OfflinePlayer

internal class PapiFormatter : IFormatter {
    override fun format(text: String, playerContext: OfflinePlayer?): String {
        val papiText = PlaceholderAPI.setPlaceholders(playerContext, text)
        return ChatColor.translateAlternateColorCodes('&', papiText)
    }
}
