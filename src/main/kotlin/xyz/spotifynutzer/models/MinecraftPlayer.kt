package xyz.spotifynutzer.models

import net.minecraft.server.v1_8_R3.IChatBaseComponent
import net.minecraft.server.v1_8_R3.PacketPlayOutChat
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player
import java.util.*

class MinecraftPlayer {

    private val player: OfflinePlayer
    private val craftPlayer: CraftPlayer

    constructor(player: OfflinePlayer) {
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

    fun getPlayer(): OfflinePlayer {
        return player
    }

    fun getCraftPlayer(): CraftPlayer {
        return craftPlayer
    }

    fun sendActionBar(message: String) {
        val packet = PacketPlayOutChat(
            IChatBaseComponent.ChatSerializer.a("{\"text\":\" ${message.replace("&", "§")} \"}"),
            2 as Byte
        )
        craftPlayer.handle.playerConnection.sendPacket(packet)
    }

    fun kick(message: String) {
        if (player.isOnline) {
            (player as Player).kickPlayer(message.replace("&", "§"))
        }
    }
}