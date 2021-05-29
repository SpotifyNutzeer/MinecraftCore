package xyz.spotifynutzer.models.player

import net.minecraft.server.v1_8_R3.IChatBaseComponent
import net.minecraft.server.v1_8_R3.PacketPlayOutChat
import org.bukkit.Bukkit
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player
import java.util.*

/**
 * @author SpotifyNutzer
 * Website: spotifynutzer.de
 * Github: https://github.com/SpotifyNutzeer
 * Erstellt von SpotifyNutzer | Paul
 **/

class MinecraftPlayer: IMinecraftPlayer {

    private val player: Player
    private val craftPlayer: CraftPlayer
    private val uuid: UUID

    constructor(uuid: UUID) {
        this.player = Bukkit.getPlayer(uuid)
        this.craftPlayer = player as CraftPlayer
        this.uuid = uuid
    }

    constructor(uuid: String) {
        this.player = Bukkit.getPlayer(uuid)
        this.craftPlayer = player as CraftPlayer
        this.uuid = UUID.fromString(uuid)
    }

    constructor(player: Player) {
        this.player = player
        this.craftPlayer = player as CraftPlayer
        this.uuid = player.uniqueId
    }

    override fun getUniqueID(): UUID {
        return player.uniqueId
    }

    override fun getUniqueIDAsString(): String {
        return player.uniqueId.toString()
    }

    override fun getName(): String {
        return player.name
    }

    override fun getPlayer(): Player {
        return player
    }

    override fun getCraftPlayer(): CraftPlayer {
        return craftPlayer
    }

    override fun sendActionbar(message: String) {
        val packet = PacketPlayOutChat(
            IChatBaseComponent.ChatSerializer.a("{\"text\":\" ${message.replace("&", "§")} \"}"),
            2 as Byte
        )
        craftPlayer.handle.playerConnection.sendPacket(packet)
    }

    override fun kick(reason: String) {
        player.kickPlayer(reason)
    }
}