package xyz.spotifynutzer.commands

import xyz.spotifynutzer.MinecraftCore

class CommandManager {

    fun registerCommands(vararg commands: ICommand) {
        val minecraftCore: MinecraftCore = MinecraftCore.getInstance()
        commands.forEach {
            minecraftCore.getCommand(it.getCommand()).executor = it
        }
    }
}