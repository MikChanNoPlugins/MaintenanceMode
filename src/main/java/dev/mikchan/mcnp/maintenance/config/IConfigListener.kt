package dev.mikchan.mcnp.maintenance.config

/**
 * A config listener interface.
 *
 * Listens to config updates.
 */
interface IConfigListener {
    /**
     * This method is called whenever config is updated.
     *
     * @param config A new state of config.
     */
    fun handleUpdate(config: IConfig)
}
