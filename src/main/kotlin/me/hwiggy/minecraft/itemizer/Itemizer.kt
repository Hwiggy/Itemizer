package me.hwiggy.minecraft.itemizer

import de.tr7zw.nbtinjector.NBTInjector
import me.hwiggy.minecraft.itemizer.menu.Menu
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.*
import org.bukkit.plugin.java.JavaPlugin

class Itemizer : JavaPlugin(), Listener {
    override fun onLoad() {
        NBTInjector.inject()
    }

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this)
    }

    private fun <T : InventoryEvent> handle(
        event: T, handler: (Menu, T) -> Unit
    ) { handler(event.inventory.holder as? Menu ?: return, event) }

    @EventHandler private fun onOpen(event: InventoryOpenEvent) = handle(event, Menu::onOpen)
    @EventHandler private fun onClose(event: InventoryCloseEvent) = handle(event, Menu::onClose)
    @EventHandler private fun onClick(event: InventoryClickEvent) = handle(event, Menu::onClick)
    @EventHandler private fun onDrag(event: InventoryDragEvent) = handle(event, Menu::onDrag)
}