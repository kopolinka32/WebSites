package me.challangersoncore.main;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {

    Main plugin;

    public Events(Main Main) {
        plugin = Main;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equals("Efekty")) {
            e.setCancelled(true);
        }

        switch(e.getCurrentItem().getType()) {
            case GOLD_BLOCK:
                if(player.getInventory().contains(Material.GOLD_ORE, 13)){
                    for(int a=0; a<13; a++) {
                        player.getInventory().remove(Material.GOLD_ORE);
                    }
                    player.sendMessage("Kliknieto bllok złota");

                } else {
                    player.sendMessage("Nie posiadasz az tylu rud  zlota");
                }
            default:
                break;
        }
    }


}