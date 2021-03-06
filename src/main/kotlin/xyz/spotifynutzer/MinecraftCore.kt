package xyz.spotifynutzer

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import xyz.spotifynutzer.commands.CommandManager
import xyz.spotifynutzer.commands.commands.MinecraftCoreCommand
import xyz.spotifynutzer.database.DatabaseManager
import xyz.spotifynutzer.database.MongoAPI
import xyz.spotifynutzer.inventory.InventoryManager
import xyz.spotifynutzer.json.ConfigManager
import xyz.spotifynutzer.json.ConfigProvider
import xyz.spotifynutzer.listeners.InventoryClickListener
import xyz.spotifynutzer.listeners.JoinListener
import xyz.spotifynutzer.manager.MinecraftPlayerCacheManager
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
    //private val databaseManager: DatabaseManager = DatabaseManager()
    private val configProvider: ConfigProvider = ConfigProvider()

    //Lateinit Class Instances
    private lateinit var commandManager: CommandManager
    private lateinit var mongoAPI: MongoAPI
    private lateinit var playerCacheManager: MinecraftPlayerCacheManager
    private lateinit var inventoryManager: InventoryManager

    //Values
    private lateinit var prefix: String

    override fun onLoad() {
        instance = this
        commandManager = CommandManager()
        playerCacheManager = MinecraftPlayerCacheManager(ArrayList())
        inventoryManager = InventoryManager()
    }

    override fun onEnable() {
        registerListeners(JoinListener(), InventoryClickListener())

        getCommandManager().registerCommands(MinecraftCoreCommand())

        Bukkit.getConsoleSender().sendMessage("§8[§aMinecraftCore§8] §aLoaded Plugin!")
    }

    override fun onDisable() {
        Bukkit.getConsoleSender().sendMessage("§8[§aMinecraftCore§8] §cUnloaded Plugin!")
    }

    private fun registerListeners(vararg listeners: Listener) {
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

    /*fun getDatabaseManager(): DatabaseManager {
        return databaseManager
    }*/

    fun getPlayerCacheManager(): MinecraftPlayerCacheManager {
        return playerCacheManager
    }

    fun injectPacketDecoder(player: Player): PacketDecoder {
        return PacketDecoder(player).inject()
    }

    fun disconnectPacketDecoder(packetDecoder: PacketDecoder) {
        packetDecoder.disconnect()
    }

    fun createNewJsonConfig(): ConfigManager {
        return ConfigManager()
    }

    fun getConfigProvider(): ConfigProvider {
        return configProvider
    }

    fun getInventoryManager(): InventoryManager {
        return inventoryManager;
    }

}