package dev.mikchan.mcnp.maintenance.command

import dev.mikchan.mcnp.maintenance.config.IConfig
import net.md_5.bungee.api.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

internal class AdminCommand(private val config: IConfig) : CommandExecutor, TabCompleter {
    private val commandMap = mapOf(
        "reload" to { sender: CommandSender ->
            config.reload()
            sender.sendMessage("${ChatColor.DARK_GREEN}Successfully Reloaded!")
        },

        "enable" to { sender: CommandSender ->
            config.enabled = true
            sender.sendMessage("${ChatColor.DARK_GREEN}Successfully Enabled!")
        },

        "disable" to { sender: CommandSender ->
            config.enabled = false
            sender.sendMessage("${ChatColor.DARK_GREEN}Successfully Disabled!")
        })

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.size != 1) {
            sender.sendMessage("${ChatColor.DARK_RED}Too many arguments!")
        }

        val arg = args[0].lowercase()
        val executor = commandMap[arg]
        if (executor == null) {
            sender.sendMessage("${ChatColor.DARK_RED}Unknown command '$arg'")
            return false
        }

        executor.invoke(sender)
        return true
    }

    override fun onTabComplete(
        sender: CommandSender, command: Command, alias: String, args: Array<out String>
    ): MutableList<String> {
        if (args.size != 1) return mutableListOf()
        return commandMap.keys.filter { it.startsWith(args[0], true) }.toMutableList()
    }
}
