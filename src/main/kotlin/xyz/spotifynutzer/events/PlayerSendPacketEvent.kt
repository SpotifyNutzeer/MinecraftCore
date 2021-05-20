package xyz.spotifynutzer.events

import io.netty.channel.Channel
import net.minecraft.server.v1_8_R3.Packet
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList


class PlayerSendPacketEvent(val player: Player, packet: Packet<*>, channel: Channel) :
    Event(), Cancellable {

    private var cancelled = false
    private val packet: Packet<*> = packet
    private val channel: Channel = channel

    /**
     * @return          the packet
     */
    fun getPacket(): Packet<*> {
        return packet
    }


    /**
     * @return          the channel
     */
    fun getChannel(): Channel {
        return channel
    }

    /**
     * @return          the Handlers
     */
    override fun getHandlers(): HandlerList {
        return handlerList
    }

    /**
     * @return          the cancle state
     */
    override fun isCancelled(): Boolean {
        return cancelled
    }

    /**
     * @param cancel    the state it will be set
     */
    override fun setCancelled(cancel: Boolean) {
        cancelled = cancel
    }

    companion object {
        val handlerList = HandlerList()
    }

}