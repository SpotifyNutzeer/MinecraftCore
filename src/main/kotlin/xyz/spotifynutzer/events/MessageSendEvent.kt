package xyz.spotifynutzer.events

import com.google.gson.JsonElement
import org.bukkit.entity.Player
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class MessageSendEvent(val player: Player, messageKey: String, jsonElement: JsonElement) :
    Event(), Cancellable {

    private var cancelled = false
    private var messageKey = ""
    private lateinit var jsonElement: JsonElement


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

    init {
        this.messageKey = messageKey
        this.jsonElement = jsonElement
    }
}