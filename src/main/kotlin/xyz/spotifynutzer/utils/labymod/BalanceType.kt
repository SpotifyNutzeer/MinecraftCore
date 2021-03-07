package xyz.spotifynutzer.utils.labymod;

/**
 * @author kxmpetentes
 * Website: kxmpetentes.de
 * GitHub: git.kxmpetentes.de
 * Erstellt am: 07.03.2021 um 10:13
 */

enum class BalanceType {

    CASH("cash"),
    BANK("bank");

    private val key: String

    constructor(key: String) {
        this.key = key
    }

    fun getKey(): String {
        return key
    }
}
