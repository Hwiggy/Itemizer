package me.hwiggy.minecraft.itemizer.item

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BundleMeta

class BundleBuilder @JvmOverloads constructor(
    configurator: BundleBuilder.() -> Unit = { }
) : AbstractItemBuilder<BundleMeta, BundleBuilder>(configurator) {
    override val material = Material.BUNDLE
    override val amount = 1

    private val items = ArrayList<ItemStack>()

    fun items(vararg item: ItemStack) = self().apply { this.items.addAll(item) }

    override fun updateMeta(meta: BundleMeta) {
        meta.setItems(items)
    }
}