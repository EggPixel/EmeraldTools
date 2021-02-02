package cn.eggpixel;

import cn.eggpixel.api.getMessages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Fly implements CommandExecutor {
    private final EmeraldTools plugin;

    public Fly(EmeraldTools plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        try {
            if (args.length == 1) {
                try {
                    Player player = Bukkit.getPlayerExact(args[0]);
                    assert player != null;
                    if (player.isFlying()) {
                        player.setAllowFlight(false);
                        sender.sendMessage(new getMessages().FLY_OFF.replace("%PLAYERNAME%", player.getName()));
                    } else {
                        player.setAllowFlight(true);
                        sender.sendMessage(new getMessages().FLY_ON.replace("%PLAYERNAME%", player.getName()));
                    }
                    return true;
                } catch (Exception a) {
                    Player player = Bukkit.getPlayer(UUID.fromString(args[0]));
                    assert player != null;
                    if (player.isFlying()) {
                        player.setAllowFlight(false);
                        sender.sendMessage(new getMessages().FLY_OFF.replace("%PLAYERNAME%", player.getName()));
                    } else {
                        player.setAllowFlight(true);
                        sender.sendMessage(new getMessages().FLY_ON.replace("%PLAYERNAME%", player.getName()));
                    }
                    return true;
                }
            } else {
                if (sender instanceof Player) {
                    try {
                        if (args.length == 0) {
                            Player player = (Player) sender;
                            if (player.isFlying()) {
                                player.setAllowFlight(false);
                                sender.sendMessage(new getMessages().FLY_OFF.replace("%PLAYERNAME%", player.getName()));
                            } else {
                                player.setAllowFlight(true);
                                sender.sendMessage(new getMessages().FLY_ON.replace("%PLAYERNAME%", player.getName()));
                            }
                            return true;
                        }
                    } catch (Exception b) {
                        sender.sendMessage(ChatColor.RED + "[EmeraldsTools] 插件发生异常，请将此消息报告于EmeraldsEgg");
                        sender.sendMessage(ChatColor.RED + "[EmeraldsTools] 错误代码: CODE_IN_FLY_63");
                        return true;
                    }
                } else {
                    sender.sendMessage(new getMessages().DO_IN_CONSOLE);
                    return true;
                }
            }
            return false;
        } catch (Exception e){
            sender.sendMessage(new getMessages().PLAYER_NOT_FOUND);
            return true;
        }
    }
}
