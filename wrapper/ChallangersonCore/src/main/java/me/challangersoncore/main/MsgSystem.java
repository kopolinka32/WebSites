package me.challangersoncore.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class MsgSystem implements CommandExecutor {

    Main plugin;

    public MsgSystem(Main m) {
        plugin = m;
        m.getCommand("msg").setExecutor(this);
        m.getCommand("r").setExecutor(this);
    }


    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {

        Player player = (Player) sender;
        UUID puuid = player.getUniqueId();
        if(arg1.getName().equalsIgnoreCase("msg")) {
            if (args.length >= 2) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    stringBuilder.append(args[i]).append(" ");
                }
                Player player2 = Bukkit.getPlayer(args[0]);
                String msg = stringBuilder.toString();
                UUID celuuid = player2.getUniqueId();

                List<String> player2Ignored = plugin.getConfig().getStringList(celuuid + ".ignored");

                if (!player2Ignored.contains(player.getDisplayName())) {
                    player.sendMessage("ty >" + player2.getDisplayName() + "] Wiadomosc: " + msg);
                    player2.sendMessage("[" + player.getDisplayName() + "> ty" + "] Wiadomosc" + msg);

                    plugin.getConfig().set(puuid + ".lastplayer", player2.getDisplayName());
                    plugin.getConfig().set(celuuid + ".lastplayer", player.getDisplayName());
                    plugin.saveConfig();
                } else {
                    player.sendMessage("Jestes na liscie zablokowanych");
                }
            } else {
                player.sendMessage("Uzycie /msg (gracz) (wiadomosc)");
            }
        }
        if(arg1.getName().equalsIgnoreCase("r")) {
            if (args.length >= 1) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    stringBuilder.append(args[i]).append(" ");
                }

                String msg = stringBuilder.toString();

                Player player2 = Bukkit.getPlayer(plugin.getConfig().getString(puuid + ".lastPlayer"));

                UUID celuuid = player2.getUniqueId();

                List<String> celIgnored = plugin.getConfig().getStringList(celuuid + ".ignored");

                if(!celIgnored.contains(player.getDisplayName())) {
                    player.sendMessage("ty >" + player2.getDisplayName() + "] Wiadomosc: " + msg);
                    player2.sendMessage("[" + player.getDisplayName() + "> ty" + "] Wiadomosc" + msg);
                } else {
                    player.sendMessage("Jestes na liscie zablokowanych");
                }
            } else {
                player.sendMessage("Uzycie /r (wiadomosc)");
            }
        }
        return  false;
    }

}
