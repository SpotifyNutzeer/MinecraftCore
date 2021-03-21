package xyz.spotifynutzer.manager

import org.bukkit.entity.Player
import xyz.spotifynutzer.models.player.MinecraftPlayer
import xyz.spotifynutzer.utils.PacketDecoder
import java.util.*
import kotlin.collections.HashMap

class MinecraftPlayerCacheManager {

    private val playerCache: ArrayList<MinecraftPlayer>
    private val packetDecoderCache: HashMap<MinecraftPlayer, PacketDecoder> = HashMap()

    /**
     * @param playerCache       PlayerCache from start
     */
    constructor(playerCache: ArrayList<MinecraftPlayer>) {
        this.playerCache = playerCache
    }

    /**
     * @param minecraftPlayer   add the player to playerCache
     */
    fun addPlayer(minecraftPlayer: MinecraftPlayer) {
        this.playerCache.add(minecraftPlayer)
    }

    /**
     * @param player            add the player to playerCache
     */
    fun addPlayer(player: Player) {
        this.playerCache.add(MinecraftPlayer(player))
    }

    /**
     * @param uuid              add the player to playerCache
     */
    fun addPlayer(uuid: String) {
        this.playerCache.add(MinecraftPlayer(uuid))
    }

    /**
     * @param uuid              add the player to playerCache
     */
    fun addPlayer(uuid: UUID) {
        this.playerCache.add(MinecraftPlayer(uuid))
    }

    /**
     * @return                  the searched minecraftPlayer
     * @param uuid              the unique id of the player
     */
    fun getPlayer(uuid: String): MinecraftPlayer {
        return this.playerCache.first { minecraftPlayer -> minecraftPlayer.getUniqueIDString() == uuid }
    }

    /**
     * @return                  the searched minecraftPlayer
     * @param uuid              the uniqueid of the player
     */
    fun getPlayer(uuid: UUID): MinecraftPlayer {
        return this.playerCache.first { minecraftPlayer -> minecraftPlayer.getUniqueID() == uuid }
    }

    /**
     * @return                  the searched minecraftPlayer
     * @param name              the playername
     */
    fun getPlayerByName(name: String): MinecraftPlayer {
        return this.playerCache.first { minecraftPlayer -> minecraftPlayer.getPlayer().name == name }
    }

    /**
     * @param minecraftPlayer   the player which has the decoder
     * @param packetDecoder     the packetdecoder which should be set
     */
    fun setPlayerPacketDecoder(minecraftPlayer: MinecraftPlayer, packetDecoder: PacketDecoder) {
        this.packetDecoderCache[minecraftPlayer] = packetDecoder
    }

    /**
     * @return                  the searched PacketDecoder
     * @param minecraftPlayer   the player which should have the decoder
     */
    fun getPlayerPacketDecoder(minecraftPlayer: MinecraftPlayer): PacketDecoder? {
        return this.packetDecoderCache[minecraftPlayer]
    }

}