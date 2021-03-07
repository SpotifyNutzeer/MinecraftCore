package xyz.spotifynutzer.utils.labymod;

/**
 * @author kxmpetentes
 * Website: kxmpetentes.de
 * GitHub: git.kxmpetentes.de
 * Erstellt am: 07.03.2021 um 10:13
 */

public enum BalanceType {

    CASH("cash"),
    BANK("bank");

    private final String key;

    BalanceType(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
