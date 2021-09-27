package me.hwiggy.minecraft.itemizer.item

import org.bukkit.Material
import org.bukkit.entity.Axolotl
import org.bukkit.inventory.meta.AxolotlBucketMeta

class AxolotlBucketBuilder @JvmOverloads constructor(
    override val amount: Int = 1,
    configurator: AxolotlBucketBuilder.() -> Unit = { }
) : AbstractItemBuilder<AxolotlBucketMeta, AxolotlBucketBuilder>(configurator) {
    override val material = Material.AXOLOTL_BUCKET
    private var variant: Axolotl.Variant? = null

    fun variant(variant: Axolotl.Variant): AxolotlBucketBuilder {
        this.variant = variant
        return this
    }

    override fun updateMeta(meta: AxolotlBucketMeta) {
        variant?.also { meta.variant = it }
    }
}