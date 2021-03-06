package xyz.spotifynutzer

import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import xyz.spotifynutzer.commands.CommandManager

class MinecraftCore : JavaPlugin() {

    //Instance
    companion object {
        private lateinit var instance: MinecraftCore

        @JvmStatic
        fun getInstance(): MinecraftCore {
            return instance
        }
    }

    //Class Instances
    private lateinit var commandManager: CommandManager

    //Values
    private lateinit var prefix: String

    override fun onEnable() {
        instance = this
        commandManager = CommandManager()
    }

    override fun onDisable() {

    }

    fun registerListeners(vararg listeners: Listener) {
        val pluginManager: PluginManager = Bukkit.getPluginManager()
        listeners.forEach {
            pluginManager.registerEvents(it, this)
        }
    }

    fun setPrefix(prefix: String) {
        this.prefix = prefix
    }

    fun getPrefix(message: String): String {
        return prefix + message
    }

    fun getPrefix(): String {
        return prefix
    }

    fun getCommandManager(): CommandManager {
        return commandManager
    }
}