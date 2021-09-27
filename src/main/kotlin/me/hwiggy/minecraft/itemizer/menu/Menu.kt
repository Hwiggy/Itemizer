package me.hwiggy.minecraft.itemizer.menu

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.event.inventory.InventoryOpenEvent
import org.bukkit.inventory.InventoryHolder

interface Menu : InventoryHolder {
    fun onOpen(event: InventoryOpenEvent) = Unit
    fun onClose(event: InventoryCloseEvent) = Unit
    fun onClick(event: InventoryClickEvent) = Unit
    fun onDrag(event: InventoryDragEvent) = Unit
}