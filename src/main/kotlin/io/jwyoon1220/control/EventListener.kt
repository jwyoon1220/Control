package io.jwyoon1220.control

import io.papermc.paper.event.player.AsyncChatEvent
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.event.player.*
import org.bukkit.plugin.java.JavaPlugin

class EventListener(plugin: JavaPlugin): Listener {
    val conf = plugin.config
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val join_message = conf.getBoolean("join-message")
        if (!join_message && !event.player.isOp) {
            event.joinMessage(null)
        }
    }
    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        val quit_message = conf.getBoolean("quit-message")
        if (!quit_message && !event.player.isOp) {
            event.quitMessage(null)
        }
    }
    @EventHandler
    fun onPlayerChat(event: AsyncChatEvent) {
        val chat_message = conf.getBoolean("chat")
        if (!chat_message && !event.player.isOp) {
            event.isCancelled = true
        }
    }
    @EventHandler
    fun onPlayerCommandProcess(event: PlayerCommandPreprocessEvent) {
        val command = conf.getBoolean("command")
        if (!command && !event.player.isOp) {
            event.isCancelled = true
        }
    }
    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        val movement = conf.getBoolean("movement")
        if (!movement && !event.player.isOp) {
            event.isCancelled = true
        }
    }
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val interact_message = conf.getBoolean("interaction")
        if (!interact_message && !event.player.isOp) {
            event.isCancelled = true
        }
    }
    @EventHandler
    fun onDamage(event: EntityDamageEvent) {
        val damage = conf.getBoolean("damage")
        if (event.entity is Player) {
            if (!damage && !event.entity.isOp) {
                event.isCancelled = true
            }
        }
    }
    @EventHandler
    fun onBreak(event: BlockBreakEvent) {
        val block = conf.getBoolean("breaking")
        if (!block && !event.player.isOp) {
            event.isCancelled = true
        }
    }
    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent) {
        val block = conf.getBoolean("placement")
        if (!block && !event.player.isOp) {
            event.isCancelled = true
        }
    }
    @EventHandler
    fun onEntityDamageByEntity(event: EntityDamageByEntityEvent) {
        if (event.entity is Player) {
            val attack = conf.getBoolean("attack")
            if (!attack && !event.entity.isOp) {
                event.isCancelled = true
            }
        }
    }
    @EventHandler
    fun onCrafting(event: CraftItemEvent) {
        val craft = conf.getBoolean("crafting")
        if (!craft && !event.whoClicked.isOp) {
            event.isCancelled = true
        }
    }
    @EventHandler
    fun fillBukkit(event: PlayerBucketFillEvent) {
        val placement = conf.getBoolean("placement")
        if (!placement && !event.player.isOp) {
            event.isCancelled = true
        }
    }
    @EventHandler
    fun emptyBukkit(event: PlayerBucketEmptyEvent) {
        val placement = conf.getBoolean("placement")
        if (!placement && !event.player.isOp) {
            event.isCancelled = true
        }
    }
}