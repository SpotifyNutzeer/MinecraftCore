package xyz.spotifynutzer.utils.labymod;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author kxmpetentes
 * Website: kxmpetentes.de
 * GitHub: git.kxmpetentes.de
 * Erstellt am: 07.03.2021 um 10:33
 */

class ActionMenuBuilder {

    private val jsonArray: JsonArray = JsonArray()

    fun addAction(displayName: String, actionType: ActionType, value: String) {
        val entry = JsonObject()
        entry.addProperty("displayName", displayName)
        entry.addProperty("type", actionType.name)
        entry.addProperty("value", value)
        jsonArray.add(entry)
    }

    fun getJsonObject(): JsonObject {
        return jsonArray.asJsonObject
    }

    fun getJsonArray(): JsonArray {
        return jsonArray
    }

    fun getObject(): String {
        return jsonArray.toString()
    }

}
