package dev.mikchan.mcnp.maintenance.config

import org.bukkit.plugin.java.JavaPlugin

internal class Config(private val plugin: JavaPlugin) : IConfig {
    private var listeners = emptySet<IConfigListener>()

    override fun subscribe(listener: IConfigListener) {
        listeners = listeners + listener
    }

    private fun broadcast() {
        val listeners = this.listeners
        for (listener in listeners) {
            listener.handleUpdate(this)
        }
    }

    override fun reload() {
        plugin.reloadConfig()
        broadcast()
    }

    override var enabled: Boolean
        get() = plugin.config.getBoolean("enabled", false)
        set(value) {
            plugin.config.set("enabled", value)
            plugin.saveConfig()
            broadcast()
        }

    override val kickMessage: String
        get() = plugin.config.getString("kick-message")?.trimIndent() ?: "The server is under maintenance"

    override val enableCustomMotd: Boolean
        get() = plugin.config.getBoolean("enable-custom-motd", false)

    override val customMotd: String
        get() = plugin.config.getString("custom-motd")?.trimIndent() ?: "The server is under maintenance"
}
