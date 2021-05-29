package xyz.spotifynutzer.commands.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import xyz.spotifynutzer.MinecraftCore
import xyz.spotifynutzer.commands.ICommand


class MinecraftCoreCommand : ICommand {

    override fun onCommand(sender: CommandSender, command: Command, string: String, args: Array<out String>): Boolean {
        if (args[0] == "version") {
            sender.sendMessage("§8[§aMinecraftCore§8] §7Version: ${MinecraftCore.getInstance().description.version}")
            return false
        }

        sender.sendMessage("§8[§aMinecraftCore§8] §7Author: ${MinecraftCore.getInstance().description.authors}")
        sender.sendMessage("§8[§aMinecraftCore§8] §7Description: ${MinecraftCore.getInstance().description.description}")
        return false
    }

    override fun onTabComplete(
        sender: CommandSender?,
        command: Command,
        string: String,
        args: Array<out String>?
    ): MutableList<String> {
        return arrayListOf("version")
    }

    override fun getCommand(): String {
        return "minecraftcore"
    }


}