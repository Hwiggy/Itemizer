package me.hwiggy.minecraft.itemizer.item

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.inventory.meta.CompassMeta

class CompassBuilder @JvmOverloads constructor(
    override val amount: Int = 1,
    configurator: CompassBuilder.() -> Unit = { }
) : AbstractItemBuilder<CompassMeta, CompassBuilder>(configurator) {
    override val material = Material.COMPASS
    private var lodestone: Location? = null
    private var tracking: Boolean = false

    fun lodestone(location: Location) = self().apply { this.lodestone = location }
    fun tracking() = self().apply { this.tracking = true }

    override fun updateMeta(meta: CompassMeta) {
        lodestone?.also { meta.lodestone = it }
        meta.isLodestoneTracked = tracking
    }
}