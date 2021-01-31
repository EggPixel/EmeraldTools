package cn.eggpixel;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kills implements CommandExecutor {
    private final EmeraldTools plugin;

    public Kills(EmeraldTools plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.setHealth(0.00);
        } else {
            sender.sendMessage(ChatColor.RED + "[EmeraldsTools] 此命令不能在控制台执行!");
        }
        return true;
    }
}