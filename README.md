[![Downloads](https://pluginbadges.glitch.me/api/v1/dl/Downloads-limegreen.svg?spigot=mikchan%25E3%2581%25AEmaintenancemode.103633&github=MikChanNoPlugins%2FMaintenanceMode&style=flat)](https://www.spigotmc.org/resources/mikchan%E3%81%AEmaintenancemode.103633/)
[![Java CI](https://github.com/MikChanNoPlugins/MaintenanceMode/actions/workflows/ci.yaml/badge.svg)](https://github.com/MikChanNoPlugins/MaintenanceMode/actions/workflows/ci.yaml)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/826eab12d79143aa9fd129742419c354)](https://www.codacy.com/gh/MikChanNoPlugins/MaintenanceMode/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=MikChanNoPlugins/MaintenanceMode&amp;utm_campaign=Badge_Grade)
[![Lines of Code](https://tokei.rs/b1/github/MikChanNoPlugins/MaintenanceMode?category=code)](https://github.com/XAMPPRocky/tokei)

# MikChanの MaintenanceMode

This plugin adds a very easy to use maintenance mode to your server. In case your production server is up, and yet you still need to do something before letting players in.

Supports PlaceholderAPI.

## Usage

First of all, you need to give the permission `mcn.maintenance.allow` to everyone who has to have access during the maintenance period, and then just write `/maintenance enable`. It will kick all other players, and not let them in till the maintenance period is over. You can disable the maintenance mode by writing `/maintenance disable`. You can also change the kick message and customize MOTD during the maintenance period by editing `config.yml`. For changes to take effect you either need to run `/maintenance reload` or restart the server.

## Supported Versions

Spigot/Paper/Bukkit 1.16.5+

## Support the creator
[!["Buy Me A Coffee"](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/mcnp)
