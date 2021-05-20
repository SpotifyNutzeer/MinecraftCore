package xyz.spotifynutzer.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.spotifynutzer.MinecraftCore;
import xyz.spotifynutzer.inventory.InventoryItem;
import xyz.spotifynutzer.inventory.InventoryManager;

/**
 * @author kxmpetentes
 * Website: kxmpetentes.de
 * GitHub: git.kxmpetentes.de
 * Erstellt am: 16.05.2021 um 20:21
 */

public class InventoryClickListener implements Listener {

    @EventHandler
    public void handle(InventoryClickEvent event) {
        InventoryAction action = event.getAction();
        ItemStack clickedItem = event.getCurrentItem();
        Inventory clickedInventory = event.getClickedInventory();

        if (clickedItem == null) return;
        if (action == null) return;
        if (clickedInventory == event.getWhoClicked().getInventory()) return;

        String inventoryTitle = clickedInventory.getTitle();
        InventoryManager inventoryManager = MinecraftCore.getInstance().getInventoryManager();

        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();

        InventoryItem inventoryItem = inventoryManager.getInventoryItem(inventoryTitle, clickedItem, event.getSlot(), action);
        if (inventoryItem == null) {
            return;
        }

        event.setCancelled(inventoryItem.isClickCanceled());
        inventoryItem.getAction().accept(player);
    }

}