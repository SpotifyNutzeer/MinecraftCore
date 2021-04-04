package xyz.spotifynutzer.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import java.util.*

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

    /**
     * @param sender            the completer
     * @param command           the command
     * @param string            the command string
     * @param args              the strings after the command string
     */
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        string: String,
        args: Array<out String>
    ): MutableList<String> {
        return Collections.singletonList("TODO")
    }
}