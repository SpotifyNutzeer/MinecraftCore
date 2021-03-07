package xyz.spotifynutzer.utils


import io.netty.channel.Channel
import io.netty.handler.codec.MessageToMessageDecoder
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
import org.bukkit.entity.Player
import org.bukkit.Bukkit

import xyz.spotifynutzer.events.PlayerSendPacketEvent

import io.netty.channel.ChannelHandlerContext
import net.minecraft.server.v1_8_R3.Packet


class PacketDecoder(private val player: Player) {

    private val channel: Channel

    init {
        this.channel = (player as CraftPlayer).handle.playerConnection.networkManager.channel
    }

    fun inject(): PacketDecoder {
        channel.pipeline().addAfter("decoder", "MinecraftCore", object : MessageToMessageDecoder<Packet<*>>() {
            override fun decode(
                channelHandlerContext: ChannelHandlerContext?,
                packet: Packet<*>,
                list: MutableList<Any?>
            ) {
                val event = PlayerSendPacketEvent(player, packet, channel)
                Bukkit.getPluginManager().callEvent(event)
                if (!event.isCancelled) list.add(packet)
            }
        })
        return this
    }

    fun disconnect() {
        if (this.channel.pipeline().get("MinecraftCore") != null) {
            channel.pipeline().remove("MinecraftCore")
        }
    }
}