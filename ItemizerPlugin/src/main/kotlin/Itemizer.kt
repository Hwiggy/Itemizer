package me.hwiggy.minecraft.itemizer

import de.tr7zw.nbtinjector.NBTInjector
import me.hwiggy.minecraft.itemizer.menu.Menu
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Itemizer : JavaPlugin(), Listener {
    override fun onLoad() {
        NBTInjector.inject()
    }

    override fun onEnable() {
        Menu.EventListener.register(this)
    }
}