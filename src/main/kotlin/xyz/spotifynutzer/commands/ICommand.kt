package xyz.spotifynutzer.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

interface ICommand: CommandExecutor {

    override fun onCommand(sender: CommandSender?, command: Command?, string: String?, args: Array<out String>?): Boolean

    fun getCommand(): String
}