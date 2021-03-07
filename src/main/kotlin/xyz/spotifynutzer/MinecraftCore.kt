package xyz.spotifynutzer

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import xyz.spotifynutzer.commands.CommandManager
import xyz.spotifynutzer.database.DatabaseManager
import xyz.spotifynutzer.database.MongoAPI
import xyz.spotifynutzer.utils.PacketDecoder

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
    private val databaseManager: DatabaseManager = DatabaseManager()

    //Lateinit Class Instances
    private lateinit var commandManager: CommandManager
    private lateinit var mongoAPI: MongoAPI

    //Values
    private lateinit var prefix: String

    override fun onLoad() {
        instance = this
        commandManager = CommandManager()
    }

    override fun onEnable() {
        Bukkit.getConsoleSender().sendMessage("§8[§aMinecraftCore§8] §aLoaded Plugin!")
    }

    override fun onDisable() {
        Bukkit.getConsoleSender().sendMessage("§8[§aMinecraftCore§8] §cUnloaded Plugin!")
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

    fun setMongoAPI(mongoAPI: MongoAPI) {
        this.mongoAPI = mongoAPI
    }

    fun getMongoAPI(): MongoAPI {
        return mongoAPI
    }

    fun getCommandManager(): CommandManager {
        return commandManager
    }

    fun getDatabaseManager(): DatabaseManager {
        return databaseManager
    }

    fun injectPacketDecoder(player: Player): PacketDecoder {
        return PacketDecoder(player).inject()
    }

    fun disconnectPacketDecoder(packetDecoder: PacketDecoder) {
        packetDecoder.disconnect()
    }
}