package xyz.spotifynutzer.json

import xyz.spotifynutzer.MinecraftCore
import java.io.File

class ConfigManager {

    private val configuration: Configuration


    /**
     * constructor with no configuration (creates empty configuration)
     */
    constructor() {
        this.configuration = Configuration()
    }

    /**
     * @param configuration             configuration to be written on
     */
    constructor(configuration: Configuration) {
        this.configuration = configuration
    }

    /**
     * @param path                      the path where the string should be written
     * @param value                     the string that should be written
     */
    fun setString(path: String, value: String) {
        this.configuration.put(path, value)
    }

    /**
     * @param path                      the path where the string should be found
     * @return                          the searched string
     * @throws NullPointerException     might produce NullPointerException
     */
    @Throws(NullPointerException::class)
    fun getString(path: String): String? {
        return this.configuration[path].toString()
    }

    /**
     * @param path                      the path where the integer should be written
     * @param value                     the integer that should be written
     */
    fun setInt(path: String, value: Int) {
        this.configuration.put(path, value)
    }

    /**
     * @param path                      the path where the int should be found
     * @return                          the searched int
     * @throws NullPointerException     might produce NullPointerException
     * @throws NumberFormatException    might produce NumberFormatException
     */
    @Throws(NumberFormatException::class, NullPointerException::class)
    fun getInt(path: String): Int? {
        return Integer.parseInt(configuration[path].toString())
    }

    /**
     * @param path                      the path where the double should be written
     * @param value                     the double that should be written
     */
    fun setDouble(path: String, value: Double) {
        this.configuration.put(path, value)
    }

    /**
     * @param path                      the path where the double should be found
     * @return                          the searched double
     * @throws NullPointerException     might produce NullPointerException
     * @throws NumberFormatException    might produce NumberFormatException
     */
    @Throws(NumberFormatException::class, NullPointerException::class)
    fun getDouble(path: String): Double? {
        return java.lang.Double.valueOf(configuration[path].toString())
    }

    /**
     * @param path                      the path where the long should be written
     * @param value                     the long that should be written
     */
    fun setLong(path: String, value: Long) {
        this.configuration.put(path, value)
    }

    /**
     * @param path                      the path where the long should be found
     * @return                          the searched long
     * @throws NullPointerException     might produce NullPointerException
     * @throws NumberFormatException    might produce NumberFormatException
     */
    @Throws(NumberFormatException::class, NullPointerException::class)
    fun getLong(path: String): Long? {
        return java.lang.Long.valueOf(configuration[path].toString())
    }

    /**
     * @param path                      the path where the value should be written
     * @param value                     the value that should be written
     */
    fun set(path: String, value: Any) {
        this.configuration.put(path, value)
    }

    /**
     * @param path                      the path where the value should be found
     * @return                          the searched value
     * @throws NullPointerException     might produce NullPointerException
     */
    @Throws(NullPointerException::class)
    fun get(path: String): Any? {
        return this.configuration[path]
    }

    fun getConfiguration(): Configuration {
        return configuration
    }

    fun getConfigMap(): Map<String, Any>? {
        return configuration.getConfig()
    }

    fun saveToFile(file: File) {
        MinecraftCore.getInstance().getConfigProvider().saveConfig(file, configuration)
    }
}