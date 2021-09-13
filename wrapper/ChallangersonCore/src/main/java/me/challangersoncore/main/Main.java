package me.challangersoncore.main;

import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class Main extends JavaPlugin implements Listener {

    private HikariDataSource hikari;

    public static Main main;
    @Override
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "PLUGIN ZALADOWANY POMYSLNIE MACIEK!");


        getConfig().options().copyDefaults(true);
        saveConfig();

        main = this;

        new TpSystem(this);
        new MsgSystem(this);
        new Efekty(this);
        new Events(main);
        getServer().getPluginManager().registerEvents(new Events(main), this);



        hikari = new HikariDataSource();

        hikari.setMaximumPoolSize(10);
        hikari.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        hikari.addDataSourceProperty("serverName", "localhost");
        hikari.addDataSourceProperty("port", "3307");
        hikari.addDataSourceProperty("databaseName", "test");
        hikari.addDataSourceProperty("user", "root");
        hikari.addDataSourceProperty("password", "");

        createTable();
    }


    public static Main getMain() {
        return main;
    }

    public void createTable(){
        try(Connection connection = hikari.getConnection();
            Statement statement = connection.createStatement();){
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Coins(UUID varchar(36), name VARCHAR(16), COINS int)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void runAssyncQuery(UUID playerUUID) {
//        Connection connection = null;
//
//        String update = "INSERT INTO baza VALUES(?, ?) ON DUPLICATE KEY UPDATE uuid=?";
//
//        PreparedStatement ps = null;
//
//        try {
//            connection = hikari.getConnection();
//
//            ps = connection.prepareStatement(update);
//            ps.setString(1, playerUUID.toString());
//            ps.setInt(2, 0);
//            ps.setString(3, playerUUID.toString());
//
//            ps.execute();
//        } catch(SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch(SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(ps != null) {
//                try {
//                    ps.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    }


}
