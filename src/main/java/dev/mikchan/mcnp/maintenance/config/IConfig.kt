package dev.mikchan.mcnp.maintenance.config

interface IConfig {
    var enabled: Boolean
    val kickMessage: String
    val enableCustomMotd: Boolean
    val customMotd: String

    fun subscribe(listener: IConfigListener)
    fun reload()
}
