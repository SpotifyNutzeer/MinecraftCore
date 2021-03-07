package xyz.spotifynutzer.utils.labymod;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author kxmpetentes
 * Website: kxmpetentes.de
 * GitHub: git.kxmpetentes.de
 * Erstellt am: 07.03.2021 um 10:33
 */

public class ActionMenuBuilder {

    private final JsonArray jsonArray = new JsonArray();

    public void addAction(String displayName, ActionType actionType, String value) {
        JsonObject entry = new JsonObject();
        entry.addProperty("displayName", displayName);
        entry.addProperty("type", actionType.name());
        entry.addProperty("value", value);
        jsonArray.add(entry);
    }

    public JsonObject getJsonObject() {
        return jsonArray.getAsJsonObject();
    }

}
