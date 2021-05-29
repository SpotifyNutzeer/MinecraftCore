package xyz.spotifynutzer.json

import java.util.*

class Configuration {

    private var config: MutableMap<String, Any>? = null

    constructor() {
        config = HashMap()
    }

    constructor(key: String, `object`: Any) {
        config = HashMap()
        (config as HashMap<String, Any>)[key] = `object`
    }

    fun getConfig(): Map<String, Any>? {
        return config
    }

    fun setConfig(config: MutableMap<String, Any>?): Configuration {
        this.config = config
        return this
    }

    fun put(key: String, value: Any) {
        config!![key] = value
    }

    fun containsKey(key: String): Boolean {
        return config!!.containsKey(key)
    }

    fun size(): Int {
        return config!!.size
    }

    fun containsValue(value: Any): Boolean {
        return config!!.containsValue(value)
    }

    operator fun get(key: String): Any? {
        return config!![key]
    }

    fun getOrDefault(key: String, defaultValue: Any): Any? {
        return config!!.getOrDefault(key, defaultValue)
    }
}