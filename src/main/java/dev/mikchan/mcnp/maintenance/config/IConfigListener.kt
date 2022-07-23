package dev.mikchan.mcnp.maintenance.config

interface IConfigListener {
    fun handleUpdate(config: IConfig)
}
