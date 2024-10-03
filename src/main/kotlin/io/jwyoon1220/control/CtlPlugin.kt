package io.jwyoon1220.control

import io.github.monun.kommand.getValue
import io.github.monun.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin

class CtlPlugin : JavaPlugin() {
    override fun onEnable() {
        saveDefaultConfig()
        server.pluginManager.registerEvents(EventListener(this), this)
        this.kommand {
            register("control", "ctl") {
                requires { isOp }
                then("chat") {
                    then("bool" to bool()) {
                        executes {
                            val bool: Boolean by it
                            config.set("chat", bool)
                            sender.sendMessage("chat = ${config.get("chat")}")
                            saveConfig()
                        }
                    }
                }
                then("command") {
                    then("bool" to bool()) {
                        executes {
                            val bool: Boolean by it
                            config.set("command", bool)
                            sender.sendMessage("command = ${config.get("command")}")
                            saveConfig()
                        }
                    }
                }
                then("movement") {
                    then("bool" to bool()) {
                        executes {
                            val bool: Boolean by it
                            config.set("movement", bool)
                            sender.sendMessage("movement = ${config.get("movement")}")
                            saveConfig()
                        }
                    }
                }
                then("attack") {
                    then("bool" to bool()) {
                        executes {
                            val bool: Boolean by it
                            config.set("attack", bool)
                            sender.sendMessage("attack = ${config.get("attack")}")
                            saveConfig()
                        }
                    }
                }
                then("damage") {
                    then("bool" to bool()) {
                        executes {
                            val bool: Boolean by it
                            config.set("damage", bool)
                            sender.sendMessage("damage = ${config.get("damage")}")
                            saveConfig()
                        }
                    }
                }
                then("interaction") {
                    then("bool" to bool()) {
                        executes {
                            val bool: Boolean by it
                            config.set("interaction", bool)
                            sender.sendMessage("interaction = ${config.get("interaction")}")
                            saveConfig()
                        }
                    }
                }
                then("breaking") {
                    then("bool" to bool()) {
                        executes {
                            val bool: Boolean by it
                            config.set("breaking", bool)
                            sender.sendMessage("breaking = ${config.get("breaking")}")
                            saveConfig()
                        }
                    }
                }
                then("placement") {
                    then("bool" to bool()) {
                        executes {
                            val bool: Boolean by it
                            config.set("placement", bool)
                            sender.sendMessage("placement = ${config.get("placement")}")
                            saveConfig()
                        }
                    }
                }
                then("crafting") {
                    then("bool" to bool()) {
                        executes {
                            val bool: Boolean by it
                            config.set("crafting", bool)
                            sender.sendMessage("crafting = ${config.get("crafting")}")
                            saveConfig()
                        }
                    }
                }
                then("join-message") {
                    then("bool" to bool()) {
                        executes {
                            val bool: Boolean by it
                            config.set("join-message", bool)
                            sender.sendMessage("join-message = ${config.get("join-message")}")
                            saveConfig()
                        }
                    }
                }
                then("quit-message") {
                    then("bool" to bool()) {
                        executes {
                            val bool: Boolean by it
                            config.set("quit-message", bool)
                            sender.sendMessage("quit-message = ${config.get("quit-message")}")
                            saveConfig()
                        }
                    }
                }
            }
        }
    }
}

