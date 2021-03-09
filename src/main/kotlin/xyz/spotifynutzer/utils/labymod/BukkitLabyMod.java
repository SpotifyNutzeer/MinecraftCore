package xyz.spotifynutzer.utils.labymod;

import com.google.gson.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import xyz.spotifynutzer.events.MessageSendEvent;
import xyz.spotifynutzer.utils.LMCUtils;
import xyz.spotifynutzer.utils.PacketUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author kxmpetentes
 * Website: kxmpetentes.de
 * GitHub: git.kxmpetentes.de
 * Erstellt am: 07.03.2021 um 09:53
 */

public class BukkitLabyMod {

    private final JsonParser jsonParser = new JsonParser();
    private final PacketUtils packetUtils = new PacketUtils();

    /**
     * Sends a JSON server-message to the player
     *
     * @param player          the player the message should be sent to
     * @param messageKey      the message's key
     * @param messageContents the message's contents
     */
    public void sendServerMessage(Player player, String messageKey, JsonElement messageContents) {
        messageContents = cloneJson(messageContents);

        // Sending the packet
        packetUtils.sendPacket(player, packetUtils.getPluginMessagePacket("LMC", LMCUtils.getBytesToSend(messageKey, messageContents.toString())));
    }

    /**
     * Clones a JsonElement
     *
     * @param cloneElement the element that should be cloned
     * @return the cloned element
     */
    public JsonElement cloneJson(JsonElement cloneElement) {
        try {
            return jsonParser.parse(cloneElement.toString());
        } catch (JsonParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void forceEmote(Player receiver, UUID npcUUID, LabyEmotes labyEmote) {
        JsonArray array = new JsonArray();

        JsonObject forcedEmote = new JsonObject();
        forcedEmote.addProperty("uuid", npcUUID.toString());
        forcedEmote.addProperty("emote_id", labyEmote.getEmoteID());
        array.add(forcedEmote);

        LMCUtils.sendLMCMessage(receiver, "emote_api", array.getAsJsonObject());
    }

    public void setSubtitle(Player receiver, UUID subtitlePlayer, String value, double size) {
        JsonArray array = new JsonArray();

        JsonObject subtitle = new JsonObject();
        subtitle.addProperty("uuid", subtitlePlayer.toString());
        subtitle.addProperty("size", size); // Range is 0.8 - 1.6 (1.6 is Minecraft default)

        if (value != null)
            subtitle.addProperty("value", value);

        array.add(subtitle);

        sendServerMessage(receiver, "account_subtitle", array);
    }

    public void sendCurrentPlayingGamemode(Player player, boolean visible, String gamemodeName) {
        JsonObject object = new JsonObject();
        object.addProperty("show_gamemode", visible); // Gamemode visible for everyone
        object.addProperty("gamemode_name", gamemodeName); // Name of the current playing gamemode

        LMCUtils.sendLMCMessage(player, "server_gamemode", object);
    }

    public void sendClientToServer(Player player, String title, String address, boolean preview) {

        JsonObject object = new JsonObject();
        object.addProperty("title", title); // Title of the warning
        object.addProperty("address", address); // Destination server address
        object.addProperty("preview", preview); // Display the server icon, motd and user count

        LMCUtils.sendLMCMessage(player, "server_switch", object);
    }

    public void recommendAddons(Player player, String addonUuid) {
        JsonObject object = new JsonObject();
        JsonArray addons = new JsonArray();

        JsonObject addon = new JsonObject();
        addon.addProperty("uuid", addonUuid); // Published uuid of the addon
        addon.addProperty("required", true); // Required for this server?
        addons.add(addon);

        object.add("addons", addons);

        LMCUtils.sendLMCMessage(player, "addon_recommendation", object);
    }

    public void updateBalanceDisplay(Player player, BalanceType type, boolean visible, int balance) {
        JsonObject economyObject = new JsonObject();
        JsonObject cashObject = new JsonObject();

        cashObject.addProperty("visible", visible);
        cashObject.addProperty("balance", balance);
        economyObject.add(type.getKey(), cashObject);

        LMCUtils.sendLMCMessage(player, "economy", economyObject);
    }

    /**
     * Just send this packet to set the cinescope coverage
     * 0% - Disabled
     * 50% - Fully blind
     */
    public void sendCineScope(Player player, int coveragePercent, long duration) {
        JsonObject object = new JsonObject();

        object.addProperty("coverage", coveragePercent);
        object.addProperty("duration", duration);

        LMCUtils.sendLMCMessage(player, "cinescopes", object);
    }

    public void playCinematic(Player player, List<Location> points, long duration) {
        JsonObject cinematic = new JsonObject();

        JsonArray pointsArray = new JsonArray();
        for (Location location : points) {
            // Add points
            JsonObject point = new JsonObject();
            point.addProperty("x", location.getX());
            point.addProperty("y", location.getY());
            point.addProperty("z", location.getZ());
            point.addProperty("yaw", location.getYaw());
            point.addProperty("pitch", location.getPitch());
            point.addProperty("tilt", 0);
            pointsArray.add(point);
        }

        cinematic.add("points", pointsArray);
        cinematic.addProperty("duration", duration);

        player.teleport(points.get(0));
        player.setAllowFlight(true);

        LMCUtils.sendLMCMessage(player, "cinematic", cinematic);
    }

    public void sendWatermark(Player player, boolean visible) {
        JsonObject object = new JsonObject();
        object.addProperty("visible", visible);

        LMCUtils.sendLMCMessage(player, "watermark", object);
    }

    /**
     * @param player          The input prompt receiver
     * @param promptSessionId A unique id for each packet, use a static number and increase it for each prompt request
     * @param message         The message above the text field
     * @param value           The value inside of the text field
     * @param placeholder     A placeholder text inside of the text field if there is no value given
     * @param maxLength       Max amount of characters of the text field value
     */
    public void sendInputPrompt(Player player, int promptSessionId, String message, String value, String placeholder, int maxLength) {
        JsonObject object = new JsonObject();
        object.addProperty("id", promptSessionId);
        object.addProperty("message", message);
        object.addProperty("value", value);
        object.addProperty("placeholder", placeholder);
        object.addProperty("max_length", maxLength);
        LMCUtils.sendLMCMessage(player, "input_prompt", object);
    }

    /**
     * Just send this packet if the player joins the server to disallow the voice chat for the entire server.
     */
    public void disableVoiceChat(Player player) {
        JsonObject object = new JsonObject();
        object.addProperty("allowed", false);

        LMCUtils.sendLMCMessage(player, "voicechat", object);
    }

    /**
     * Recommend or force player to change the voice chat settings
     */
    public void sendSettings(Player player, boolean keepSettings, boolean required) {
        JsonObject voicechatObject = new JsonObject();
        voicechatObject.addProperty("keep_settings_on_server_switch", keepSettings);

        JsonObject requestSettingsObject = new JsonObject();
        requestSettingsObject.addProperty("required", required);

        JsonObject settingsObject = new JsonObject();

        settingsObject.addProperty("enabled", true); // Force player to enable the VoiceChat
        settingsObject.addProperty("microphoneVolume", 10); // Own microphone volume. (0 - 10, Default 10)
        settingsObject.addProperty("surroundRange", 10); // Range of the players you can hear (5 - 18, Default: 10)
        settingsObject.addProperty("surroundVolume", 10); // Volume of other players (0 - 10, Default: 10)
        settingsObject.addProperty("continuousTransmission", false); // Speak without push to talk

        requestSettingsObject.add("settings", settingsObject);
        voicechatObject.add("request_settings", requestSettingsObject);

        LMCUtils.sendLMCMessage(player, "voicechat", voicechatObject);
    }


    /**
     * Mute a player for someone
     */
    public void sendMutedPlayerTo(Player player, UUID mutedPlayer, boolean muted) {
        JsonObject voicechatObject = new JsonObject();
        JsonObject mutePlayerObject = new JsonObject();

        mutePlayerObject.addProperty("mute", muted);
        mutePlayerObject.addProperty("target", mutedPlayer.toString());

        voicechatObject.add("mute_player", mutePlayerObject);

        // Send to LabyMod using the API
        LMCUtils.sendLMCMessage(player, "voicechat", voicechatObject);
    }

    public void setMiddleClickActions(Player player, ActionMenuBuilder actionMenuBuilder) {
        sendServerMessage(player, "user_menu_actions", actionMenuBuilder.getJsonArray());
    }

}