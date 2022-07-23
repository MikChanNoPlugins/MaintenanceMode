package dev.mikchan.mcnp.maintenance.formatter

import net.md_5.bungee.api.ChatColor
import org.bukkit.OfflinePlayer

internal class DefaultFormatter : IFormatter {
    override fun format(text: String, playerContext: OfflinePlayer?): String {
        return ChatColor.translateAlternateColorCodes('&', text)
    }
}
