package cn.eggpixel;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;

import java.util.ArrayList;
import java.util.List;

public class PlayerLogin implements Listener {
    private static List<String> unVerifyList = new ArrayList<>();
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String playerName = player.getName();
        player.sendMessage(ChatColor.GREEN + "欢迎来到此服务器!");
        player.sendMessage(ChatColor.RED + "请输入 .emeraldegg 来进入服务器");
        unVerifyList.add(playerName);
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String playerName = player.getName();
        unVerifyList.remove(playerName);
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent f) {
        String playerName = f.getPlayer().getName();
        if (unVerifyList.contains(playerName)) {
            f.getPlayer().sendMessage(ChatColor.RED + "请输入 .emeraldegg 来进入服务器");
            f.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerChat(PlayerChatEvent f) {
        String playerName = f.getPlayer().getName();
        if (unVerifyList.contains(playerName)) {
            if(f.getMessage().charAt(0) == '/') {
                f.setCancelled(true);
                f.getPlayer().sendMessage(ChatColor.RED + "请输入 .emeraldegg 来进入服务器");
                return;
            }
            else {
                try {
                    if (f.getMessage().substring(0, 11).equals(".emeraldegg")) {
                        f.setCancelled(true);
                        f.getPlayer().sendMessage(ChatColor.GREEN + "你好!" + ChatColor.YELLOW + f.getPlayer().getName() + ChatColor.GREEN + ",欢迎来到服务器!您已验证成功!");
                        unVerifyList.remove(playerName);
                        return;
                    }
                } catch (Exception c) {
                    f.getPlayer().sendMessage(ChatColor.RED + "请输入 .emeraldegg 来进入服务器");
                    f.setCancelled(true);
                    return;
                }
                f.getPlayer().sendMessage(ChatColor.RED + "请输入 .emeraldegg 来进入服务器");
                f.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent f) {
        String playerName = f.getPlayer().getName();
        if (unVerifyList.contains(playerName)) {
            f.getPlayer().sendMessage(ChatColor.RED + "请输入 .emeraldegg 来进入服务器");
            f.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerOpen(InventoryOpenEvent f) {
        String playerName = f.getPlayer().getName();
        if (unVerifyList.contains(playerName)) {
            f.getPlayer().sendMessage(ChatColor.RED + "请输入 .emeraldegg 来进入服务器");
            f.setCancelled(true);
        }
    }
}
