package cn.eggpixel.Command;

import cn.eggpixel.EmeraldTools;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cn.eggpixel.API.getMessages;


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
            sender.sendMessage(new getMessages().DO_IN_CONSOLE);
        }
        return true;
    }
}