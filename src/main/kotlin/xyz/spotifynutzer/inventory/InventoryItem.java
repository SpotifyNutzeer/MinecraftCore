package xyz.spotifynutzer.inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

/**
 * @author kxmpetentes
 * Website: kxmpetentes.de
 * GitHub: git.kxmpetentes.de
 * Erstellt am: 16.05.2021 um 21:47
 */

public class InventoryItem {

    private final Inventory inventory;
    private final ItemStack itemStack;
    private final int slot;
    private final InventoryAction inventoryAction;
    private final Consumer<Player> action;
    private final boolean cancelClick;

    public InventoryItem(Inventory inventory, ItemStack itemStack, int slot, boolean cancelClick, InventoryAction inventoryAction, Consumer<Player> action) {
        this.inventory = inventory;
        this.itemStack = itemStack;
        this.slot = slot;
        this.cancelClick = cancelClick;
        this.inventoryAction = inventoryAction;
        this.action = action;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getSlot() {
        return slot;
    }

    public boolean isClickCanceled() {
        return cancelClick;
    }

    public InventoryAction getInventoryAction() {
        return inventoryAction;
    }

    public Consumer<Player> getAction() {
        return action;
    }
}