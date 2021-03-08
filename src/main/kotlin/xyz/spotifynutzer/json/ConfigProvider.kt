package xyz.spotifynutzer.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.jetbrains.annotations.NotNull
import java.io.File
import java.io.IOException


class ConfigProvider {

    private lateinit var configuration: Configuration
    private val objectMapper: ObjectMapper = ObjectMapper()

    @Throws(ConfigurationException::class, IOException::class)
    fun saveConfig(@NotNull file: File) {
        if (this.configuration != null) {
            throw Exception("Configuration cannot be null!")
        }

        objectMapper.writeValue(file, this.configuration)
    }

    @Throws(IOException::class, ConfigurationException::class)
    fun saveConfig(@NotNull file: File, @NotNull configuration: Configuration) {
        setConfiguration(configuration)
        saveConfig(file)
    }

    @Throws(IOException::class)
    fun getConfigFromFile(file: File?): Configuration? {
        return objectMapper.readValue(file, Configuration::class.java)
    }

    fun setConfiguration(configuration: Configuration) {
        this.configuration = configuration
    }

    fun getConfiguration(): Configuration {
        return this.configuration
    }

}