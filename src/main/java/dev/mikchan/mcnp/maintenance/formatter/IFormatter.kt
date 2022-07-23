package dev.mikchan.mcnp.maintenance.formatter

import org.bukkit.OfflinePlayer

internal interface IFormatter {
    fun format(text: String, playerContext: OfflinePlayer?): String
}
