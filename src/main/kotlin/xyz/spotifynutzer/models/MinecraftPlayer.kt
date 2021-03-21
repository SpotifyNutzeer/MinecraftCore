package xyz.spotifynutzer.models

import net.minecraft.server.v1_8_R3.IChatBaseComponent
import net.minecraft.server.v1_8_R3.PacketPlayOutChat
import org.bukkit.Bukkit
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player
import xyz.spotifynutzer.property.IProperty
import xyz.spotifynutzer.property.Property
import java.util.*

class MinecraftPlayer {

    private val player: Player
    private val craftPlayer: CraftPlayer

    constructor(player: Player) {
        this.player = player
        this.craftPlayer = player as CraftPlayer
    }

    constructor(uuid: UUID) {
        this.player = Bukkit.getServer().getPlayer(uuid)
        this.craftPlayer = this.player as CraftPlayer
    }

    constructor(uuid: String) {
        this.player = Bukkit.getServer().getPlayer(uuid)
        this.craftPlayer = this.player as CraftPlayer
    }

    fun getUniqueID(): UUID {
        return player.uniqueId
    }

    fun getUniqueIDString(): String {
        return player.uniqueId.toString()
    }

    fun getPlayer(): Player {
        return player
    }

    fun getCraftPlayer(): CraftPlayer {
        return craftPlayer
    }

    fun sendActionBar(message: String) {
        val packet: PacketPlayOutChat = PacketPlayOutChat(
            IChatBaseComponent.ChatSerializer.a("{\"text\":\" ${message.replace("&", "§")} \"}"),
            2 as Byte
        )
        craftPlayer.handle.playerConnection.sendPacket(packet)
    }

    fun kick(message: String) {
        player.kickPlayer(message.replace("&", "§"))
    }

}