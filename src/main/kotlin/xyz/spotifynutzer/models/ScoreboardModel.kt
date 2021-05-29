package xyz.spotifynutzer.models

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scoreboard.Objective
import org.bukkit.scoreboard.Scoreboard

data class ScoreboardModel(private val displayName: String, private val name: String) {

    private val scoreboard: Scoreboard? = Bukkit.getScoreboardManager().newScoreboard
    private val objective: Objective? = scoreboard?.registerNewObjective(name, name)

    init {
        objective?.displayName = displayName
    }

    fun addScore(text: String, score: Int): ScoreboardModel {
        objective?.getScore(text)?.score = score
        return this
    }

    fun setScoreboard(player: Player) {
        player.scoreboard = scoreboard
    }

    fun getScoreboard(): Scoreboard? {
        return this.scoreboard
    }
}