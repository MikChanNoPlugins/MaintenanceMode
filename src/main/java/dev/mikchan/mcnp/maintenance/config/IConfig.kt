package dev.mikchan.mcnp.maintenance.config

/**
 * The config interface
 */
interface IConfig {
    /**
     * Is the maintenance mode enabled
     */
    var enabled: Boolean

    /**
     * The message player sees when tries to connect to the server, while [enabled] is `true`
     */
    val kickMessage: String

    /**
     * Should the server also display a custom MOTD when pinged while in maintenance mode
     */
    val enableCustomMotd: Boolean

    /**
     * The MOTD which is displayed if [enabled] and [enableCustomMotd] are `true`
     */
    val customMotd: String

    /**
     * Subscribes a new config listener.
     *
     * Whenever config is updated, [IConfigListener.handleUpdate] will be called on every listener.
     *
     * @param listener A listener to subscribe.
     */
    fun subscribe(listener: IConfigListener)

    /**
     * Reloads the config from the file.
     */
    fun reload()
}
