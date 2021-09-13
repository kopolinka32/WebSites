package me.challangersoncore.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public class Efekty implements Listener, CommandExecutor {
    Main plugin;


    public Efekty(Main m) {
        m.getCommand("efekty").setExecutor(this);
        plugin = m;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("efekty")) {
                OpenEfekty(p);
            }
        }
        return false;
    }


    public static void OpenEfekty(Player player) {
        Inventory inv = Bukkit.createInventory(null, 6 * 9, ("Efekty"));

        for(int i = 0; i <= 53; i ++) {
            inv.setItem(i, (new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)).setTitle("§7").build());
        }

        inv.setItem(10,(new ItemBuilder(Material.TURTLE_HELMET)).setTitle("§eNight Vistion").build());
        inv.setItem(12,(new ItemBuilder(Material.IRON_BOOTS)).setTitle("§7Speed I").build());
        inv.setItem(14,(new ItemBuilder(Material.IRON_PICKAXE)).setTitle("§eHaste I").build());
        inv.setItem(16,(new ItemBuilder(Material.IRON_SWORD)).setTitle("§cStrength I").build());
        inv.setItem(19,(new ItemBuilder(Material.FIRE_CHARGE)).setTitle("§6Fire Resistance").build());
        inv.setItem(21,(new ItemBuilder(Material.DIAMOND_BOOTS)).setTitle("§7Speed II").build());
        inv.setItem(23,(new ItemBuilder(Material.DIAMOND_PICKAXE)).setTitle("§eHaste II").build());
        inv.setItem(25,(new ItemBuilder(Material.DIAMOND_SWORD)).setTitle("§cStrength II").build());
        inv.setItem(30,(new ItemBuilder(Material.TURTLE_HELMET)).setTitle("§eNight Vistion").build());
        inv.setItem(32,(new ItemBuilder(Material.TURTLE_HELMET)).setTitle("§eNight Vistion").build());
        inv.setItem(51,(new ItemBuilder(Material.TURTLE_HELMET)).setTitle("§eNight Vistion").build());

        player.openInventory(inv);
    }

}
