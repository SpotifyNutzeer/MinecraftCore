package xyz.spotifynutzer.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

interface ICommand : CommandExecutor, TabCompleter {

    /**
     * @param sender            the commandSender
     * @param command           the command
     * @param string            the command string
     * @param args              the strings after the command string
     */
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        string: String,
        args: Array<out String>
    ): Boolean


    /**
     * @return the String, when the command should be called
     */
    fun getCommand(): String

    override fun onTabComplete(
        p0: CommandSender?,
        p1: Command?,
        p2: String?,
        p3: Array<out String>?
    ): MutableList<String> {
        TODO("No imt yetplemented")
    }
}