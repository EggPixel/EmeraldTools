package cn.eggpixel;

import cn.eggpixel.api.getMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Burn implements CommandExecutor {
    private final EmeraldTools plugin;
    public Burn(EmeraldTools plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            try {
                Player player = Bukkit.getPlayerExact(args[0]);
                player.setFireTicks(100);
                sender.sendMessage(new getMessages().BURN_PLAYER.replace("%PLAYERNAME%", player.getName()));
                return true;
            } catch (Exception e) {
                sender.sendMessage(new getMessages().PLAYER_NOT_FOUND);
                return true;
            }
        }
        if (args.length == 2) {
            try {
                Player player = Bukkit.getPlayerExact(args[0]);
                try {
                    int tick = Integer.parseInt(args[1]);
                    player.setFireTicks(tick);
                    sender.sendMessage(new getMessages().BURN_PLAYER.replace("%PLAYERNAME%", player.getName()));
                    return true;
                } catch (Exception a) {
                    return false;
                }
            } catch (Exception e) {
                sender.sendMessage(new getMessages().PLAYER_NOT_FOUND);
                return true;
            }
        }
        return false;
    }
}
