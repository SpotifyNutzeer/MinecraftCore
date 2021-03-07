package xyz.spotifynutzer.events

import io.netty.channel.Channel
import net.minecraft.server.v1_8_R3.Packet
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList
import org.bukkit.entity.Player


class PlayerSendPacketEvent(val player: Player, packet: Packet<*>, channel: Channel) :
    Event(), Cancellable {

    private var cancelled = false
    private val packet: Packet<*>
    private val channel: Channel
    fun getPacket(): Packet<*> {
        return packet
    }

    fun getChannel(): Channel {
        return channel
    }

    override fun getHandlers(): HandlerList {
        return handlerList
    }

    override fun isCancelled(): Boolean {
        return cancelled
    }

    override fun setCancelled(cancel: Boolean) {
        cancelled = cancel
    }

    companion object {
        val handlerList = HandlerList()
    }

    init {
        this.packet = packet
        this.channel = channel
    }
}