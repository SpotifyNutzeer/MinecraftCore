package xyz.spotifynutzer.utils

import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.ItemFlag

import org.bukkit.inventory.meta.SkullMeta

import org.bukkit.inventory.meta.LeatherArmorMeta

import org.bukkit.potion.Potion

import org.bukkit.material.MaterialData
import java.util.*


class ItemBuilder {

    private var material: Material? = null
    private var amount = 1
    private var name: String? = null
    private val lores: MutableList<String> = ArrayList()
    private var durability: Short = -101
    private var data: MaterialData? = null
    private var potion: Potion? = null
    private var color: Color? = null
    private val enchants = HashMap<Enchantment, Int>()
    private var unbreakable = false

    constructor(material: Material?) {
        this.material = material
    }

    constructor(material: Material?, amount: Int) {
        this.material = material
        this.amount = amount
    }

    fun withAmount(amount: Int): ItemBuilder {
        this.amount = amount
        return this
    }

    fun withName(name: String?): ItemBuilder {
        this.name = name
        return this
    }

    fun makeUnbreakable(): ItemBuilder {
        unbreakable = true
        return this
    }

    fun withLores(vararg lores: String): ItemBuilder {
        this.lores.addAll(lores)
        return this
    }

    fun withLores(lores: List<String>?): ItemBuilder {
        this.lores.addAll(lores!!)
        return this
    }

    fun withLore(lore: String): ItemBuilder {
        lores.add(lore)
        return this
    }

    fun withDurability(durability: Short): ItemBuilder {
        this.durability = durability
        return this
    }

    fun withData(data: MaterialData?): ItemBuilder {
        this.data = data
        return this
    }

    fun withPotion(potion: Potion?): ItemBuilder {
        this.potion = potion
        return this
    }

    fun withColor(color: Color?): ItemBuilder {
        this.color = color
        return this
    }

    fun withEnchantment(enchantment: Enchantment, x: Int): ItemBuilder {
        enchants[enchantment] = x
        return this
    }

    fun toItemStack(glow: Boolean): ItemStack? {
        val item = ItemStack(material)
        item.amount = amount
        val meta = item.itemMeta
        if (unbreakable) {
            meta.spigot().isUnbreakable = true
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        }
        if (name != null && name !== "") {
            meta.displayName = name
        }
        if (!lores.isEmpty()) {
            meta.lore = lores
        }
        if (durability.toInt() != -101) {
            item.durability = durability
        }
        if (data != null) {
            item.data = data
        }
        if (potion != null && material == Material.POTION) {
            potion!!.apply(item)
        }
        if (color != null && meta is LeatherArmorMeta) {
            meta.color = color
        }
        return getItemStack(glow, item, meta)
    }

    private fun getItemStack(glow: Boolean, item: ItemStack, meta: ItemMeta): ItemStack? {
        if (glow) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
            meta.addEnchant(Enchantment.WATER_WORKER, 1, false)
        }
        val var4: Iterator<*> = enchants.entries.iterator()
        while (var4.hasNext()) {
            val set: Map.Entry<*, *> = var4.next() as Map.Entry<*, *>
            meta.addEnchant(set.key as Enchantment?, set.value as Int, true)
        }
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
        item.itemMeta = meta
        return item
    }

    fun toItemStack(): ItemStack {
        val item = ItemStack(material)
        item.amount = amount
        val meta = item.itemMeta
        if (unbreakable) {
            meta.spigot().isUnbreakable = true
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        }
        if (name != null && name !== "") {
            meta.displayName = name
        }
        if (!lores.isEmpty()) {
            meta.lore = lores
        }
        if (durability.toInt() != -101) {
            item.durability = durability
        }
        if (data != null) {
            item.data = data
        }
        if (potion != null && material == Material.POTION) {
            potion!!.apply(item)
        }
        if (color != null && meta is LeatherArmorMeta) {
            meta.color = color
        }
        val var3: Iterator<*> = enchants.entries.iterator()
        while (var3.hasNext()) {
            val set: Map.Entry<*, *> = var3.next() as Map.Entry<*, *>
            meta.addEnchant(set.key as Enchantment?, set.value as Int, true)
        }
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
        item.itemMeta = meta
        return item
    }

    fun toItemStack(b: Byte): ItemStack? {
        val item = ItemStack(material, 1, b.toShort())
        item.amount = amount
        val meta = item.itemMeta
        if (unbreakable) {
            meta.spigot().isUnbreakable = true
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        }
        if (name != null && name !== "") {
            meta.displayName = name
        }
        if (!lores.isEmpty()) {
            meta.lore = lores
        }
        if (durability.toInt() != -101) {
            item.durability = durability
        }
        if (data != null) {
            item.data = data
        }
        if (potion != null && material == Material.POTION) {
            potion!!.apply(item)
        }
        if (color != null && meta is LeatherArmorMeta) {
            meta.color = color
        }
        val var4: Iterator<*> = enchants.entries.iterator()
        while (var4.hasNext()) {
            val set: Map.Entry<*, *> = var4.next() as Map.Entry<*, *>
            meta.addEnchant(set.key as Enchantment?, set.value as Int, true)
        }
        meta.addItemFlags(*arrayOf(ItemFlag.HIDE_ATTRIBUTES))
        item.itemMeta = meta
        return item
    }

    fun toItemStack(glow: Boolean, b: Byte): ItemStack? {
        val item = ItemStack(material, 1, b.toShort())
        item.amount = amount
        val meta = item.itemMeta
        if (unbreakable) {
            meta.spigot().isUnbreakable = true
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        }
        if (name != null && name !== "") {
            meta.displayName = name
        }
        if (lores.isNotEmpty()) {
            meta.lore = lores
        }
        if (durability.toInt() != -101) {
            item.durability = durability
        }
        if (data != null) {
            item.data = data
        }
        if (potion != null && material == Material.POTION) {
            potion!!.apply(item)
        }
        if (color != null && meta is LeatherArmorMeta) {
            meta.color = color
        }
        return getItemStack(glow, item, meta)
    }

    fun toPlayerHead(ownername: String?): ItemStack {
        val item = ItemStack(material, 1, 3.toShort())
        item.amount = amount
        val meta = item.itemMeta
        if (name != null && name !== "") {
            meta.displayName = name
        }
        if (lores.isNotEmpty()) {
            meta.lore = lores
        }
        if (durability.toInt() != -101) {
            item.durability = durability
        }
        if (data != null) {
            item.data = data
        }
        if (potion != null && material == Material.POTION) {
            potion!!.apply(item)
        }
        if (color != null && meta is LeatherArmorMeta) {
            meta.color = color
        }
        (meta as SkullMeta).owner = ownername
        val var4: Iterator<*> = enchants.entries.iterator()
        while (var4.hasNext()) {
            val set: Map.Entry<*, *> = var4.next() as Map.Entry<*, *>
            meta.addEnchant(set.key as Enchantment?, set.value as Int, true)
        }
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
        item.itemMeta = meta
        return item
    }
}