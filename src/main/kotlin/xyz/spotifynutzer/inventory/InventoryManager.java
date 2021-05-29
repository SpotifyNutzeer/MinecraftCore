package xyz.spotifynutzer.inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author kxmpetentes
 * Website: kxmpetentes.de
 * GitHub: git.kxmpetentes.de
 * Erstellt am: 16.05.2021 um 20:23
 */

public class InventoryManager {

    private final List<InventoryItem> inventoryItems;

    public InventoryManager() {
        this.inventoryItems = new ArrayList<>();
    }

    public void addAction(InventoryBuilder inventoryBuilder, ItemStack lastItem, int lastSlot, boolean cancelClick, InventoryAction inventoryAction, Consumer<Player> playerConsumer) {
        InventoryItem inventoryItem = new InventoryItem(inventoryBuilder.getInventory(), lastItem, lastSlot, cancelClick, inventoryAction, playerConsumer);
        inventoryItems.add(inventoryItem);
    }

    public InventoryItem getInventoryItem(String inventoryTitle, ItemStack itemStack, int slot, InventoryAction inventoryAction) {
        for (InventoryItem inventoryItem : inventoryItems) {

            if (!inventoryItem.getInventory().getTitle().equals(inventoryTitle)) continue;
            if (!inventoryItem.getItemStack().equals(itemStack)) continue;
            if (inventoryItem.getSlot() != slot) continue;
            if (!inventoryItem.getInventoryAction().equals(inventoryAction)) continue;

            return inventoryItem;
        }

        return null;
    }

}