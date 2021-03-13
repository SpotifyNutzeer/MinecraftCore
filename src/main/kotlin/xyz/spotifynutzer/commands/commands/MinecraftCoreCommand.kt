package xyz.spotifynutzer.commands.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import xyz.spotifynutzer.MinecraftCore
import xyz.spotifynutzer.commands.ICommand


class MinecraftCoreCommand : ICommand {

    override fun onCommand(sender: CommandSender, command: Command, string: String, args: Array<out String>): Boolean {
        sender.sendMessage("§8[§aMinecraftCore§8] §7Version: ${MinecraftCore.getInstance().description.version}")
        sender.sendMessage("§8[§aMinecraftCore§8] §7Author: ${MinecraftCore.getInstance().description.authors}")
        sender.sendMessage("§8[§aMinecraftCore§8] §7Description: ${MinecraftCore.getInstance().description.description}")
        return false
    }

    override fun getCommand(): String {
        return "minecraftcore"
    }


}