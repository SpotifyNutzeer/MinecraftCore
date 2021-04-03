package xyz.spotifynutzer.models.player

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player
import java.util.*

/**
 * @author SpotifyNutzer
 * Website: spotifynutzer.de
 * Github: https://github.com/SpotifyNutzeer
 * Erstellt von SpotifyNutzer | Paul
 **/

interface IMinecraftPlayer {

    fun getUniqueID(): UUID

    fun getUniqueIDAsString(): String

    fun getName(): String

    fun getPlayer(): Player

    fun getCraftPlayer(): CraftPlayer

    fun sendActionbar(message: String)

    fun kick(reason: String)
}