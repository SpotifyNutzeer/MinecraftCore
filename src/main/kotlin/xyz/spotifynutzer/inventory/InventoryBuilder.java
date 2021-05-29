package xyz.spotifynutzer.inventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.spotifynutzer.MinecraftCore;

import java.util.function.Consumer;

/**
 * @author kxmpetentes
 * Website: kxmpetentes.de
 * GitHub: git.kxmpetentes.de
 * Erstellt am: 16.05.2021 um 20:25
 */

public class InventoryBuilder {

    private final Inventory inventory;

    private ItemStack lastItem = null;
    private int lastSlot;
    private boolean clickable = false;

    public InventoryBuilder(String inventoryTitle, int inventorySize) {
        this.inventory = Bukkit.createInventory(null, inventorySize, inventoryTitle);
    }

    public InventoryBuilder addItem(ItemStack itemStack, int slot) {
        this.inventory.setItem(slot, itemStack);

        this.lastItem = itemStack;
        this.lastSlot = slot;

        return this;
    }

    public InventoryBuilder cancelClick(boolean clickable) {
        this.clickable = clickable;

        return this;
    }

    public InventoryBuilder addAction(InventoryAction inventoryAction, Consumer<Player> action) {
        if (lastItem == null) return this;

        MinecraftCore.getInstance().getInventoryManager().addAction(this, lastItem, lastSlot, clickable, inventoryAction, action);
        return this;
    }

    public Inventory getInventory() {
        return inventory;
    }

}