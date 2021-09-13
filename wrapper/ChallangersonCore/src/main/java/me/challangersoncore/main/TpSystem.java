package me.challangersoncore.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;


import org.bukkit.event.Listener;
import java.util.HashMap;


public class TpSystem implements CommandExecutor, Listener {

    Main plugin;

    public HashMap<Player, Player> tpa = new HashMap<Player, Player>();

    public TpSystem(Main m) {
        plugin = m;
        m.getCommand("tpa").setExecutor(this);
        m.getCommand("tpaccept").setExecutor(this);
        m.getCommand("tpdeny").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {

        if (sender instanceof Player) {
            if (cmd.getName().equalsIgnoreCase("tpa")) {
                Player player = (Player) sender;
                if(args.length == 1) {
                    Player player2 = Bukkit.getPlayer(args[0]);
                    if(player2 != null && player2.isOnline()) {
                        if(!player.getName().equals((player2.getName()))) {
                            if(!tpa.containsKey(player)) {
                                tpa.put(player2, player);
                                player.sendMessage("§a§lTeleport! §7Wyslano prosbe do gracza §e" + player2.getName());
                                player2.sendMessage("§a§lTeleport! §7Gracz §e" + player.getName() + " §7probuje wykonac do ciebie teleportacje");
                            } else {
                                player.sendMessage("§c§lTeleport! §7Nie mozna teleportowac sie do gracza §e" + player2.getName());
                            }
                        } else {
                            player.sendMessage("§c§lTeleport! §7Nie mozesz wykonac teleportacji do samego siebie!");
                        }
                    } else {
                        player.sendMessage("§c§lTeleportacja! §7Gracz §e" + args[0] + " §7jest §coffline");
                    }
                } else {
                    player.sendMessage("§c§lTeleport! §7Poprawna komenda §e/tpa §c(nick)");
                }
            }
            if (cmd.getName().equalsIgnoreCase("tpaccept")) {
                Player player = (Player) sender;
                if(args.length == 1) {
                    if(tpa.containsKey(player)) {
                        Player player1 = tpa.get(player);
                        if(player1 != null && player1.isOnline()) {
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                @Override
                                public void run() {
                                    player1.teleport(player.getLocation());
                                    tpa.remove(player, player1);

                                    player1.sendMessage("§a§lTeleportacja! §7Gracz §e" + player.getName() + " §7zostal przeteleportowany do cb");
                                    player.sendMessage("§a§lTeleportacja! §7Gracz §e" + player1.getName() + " §7przeteleportowal sie do cb");
                                }
                            }, 100L);
                        } else {
                            player.sendMessage("§c§lTeleportacja! §7Gracz jest §eOFFLINE");

                            tpa.remove(player);
                        }
                    } else {
                        player.sendMessage("§c§lTeleportacja! §7Nie masz prosby o teleprotacje od tego gracza!");
                    }
                }
                return true;
            }
            if (cmd.getName().equalsIgnoreCase("tpdeny")) {
                Player player = (Player) sender;
            }
        }
        return true;
    }

    public void onMove(PlayerMoveEvent e) {
        if(e.getFrom().getZ() != e.getTo().getZ() && e.getFrom().getX() != e.getTo().getX()) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Wykryto ruch!");
        }
    }


}
