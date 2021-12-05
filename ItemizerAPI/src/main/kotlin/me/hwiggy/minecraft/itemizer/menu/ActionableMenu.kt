package me.hwiggy.minecraft.itemizer.menu

import de.tr7zw.changeme.nbtapi.NBTItem
import org.bukkit.event.inventory.InventoryClickEvent

abstract class ActionableMenu : Menu {
    protected val actionKey = "menu:action"
    final override fun onClick(event: InventoryClickEvent) {
        val stack = event.currentItem ?: return
        val item = NBTItem(stack)
        if (!item.hasKey(actionKey)) return
        val action = item.getString(actionKey)
        onClick(action, event)
        event.isCancelled = true
    }

    abstract fun onClick(action: String, event: InventoryClickEvent)
}