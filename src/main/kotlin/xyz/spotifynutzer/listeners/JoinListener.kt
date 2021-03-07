package xyz.spotifynutzer.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import xyz.spotifynutzer.MinecraftCore

class JoinListener : Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        MinecraftCore.getInstance().getPlayerCacheManager().addPlayer(event.player)
        MinecraftCore.getInstance().getPlayerCacheManager().setPlayerPacketDecoder(
            MinecraftCore.getInstance().getPlayerCacheManager().getPlayer(event.player.uniqueId),
            MinecraftCore.getInstance().injectPacketDecoder(event.player)
        )
    }
}