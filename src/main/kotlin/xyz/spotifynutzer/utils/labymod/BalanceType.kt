package xyz.spotifynutzer.utils.labymod;

/**
 * @author kxmpetentes
 * Website: kxmpetentes.de
 * GitHub: git.kxmpetentes.de
 * Erstellt am: 07.03.2021 um 10:13
 */

enum class BalanceType(private val key: String) {

    CASH("cash"),
    BANK("bank");

    fun getKey(): String {
        return key
    }
}
