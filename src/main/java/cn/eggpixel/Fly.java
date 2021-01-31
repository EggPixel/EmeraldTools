package cn.eggpixel;

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
                        sender.sendMessage(ChatColor.GREEN + "已将" + args[0] + "的飞行状态设置为" + ChatColor.YELLOW + "关闭");
                    } else {
                        player.setAllowFlight(true);
                        sender.sendMessage(ChatColor.GREEN + "已将" + args[0] + "的飞行状态设置为" + ChatColor.YELLOW + "开启");
                    }
                    return true;
                } catch (Exception a) {
                    Player player = Bukkit.getPlayer(UUID.fromString(args[0]));
                    assert player != null;
                    if (player.isFlying()) {
                        player.setAllowFlight(false);
                        sender.sendMessage(ChatColor.GREEN + "已将玩家的飞行状态设置为" + ChatColor.YELLOW + "关闭");
                    } else {
                        player.setAllowFlight(true);
                        sender.sendMessage(ChatColor.GREEN + "已将玩家的飞行状态设置为" + ChatColor.YELLOW + "开启");
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
                                sender.sendMessage(ChatColor.GREEN + "已将" + sender.getName() + "的飞行状态设置为" + ChatColor.YELLOW + "关闭");
                            } else {
                                player.setAllowFlight(true);
                                sender.sendMessage(ChatColor.GREEN + "已将" + sender.getName() + "的飞行状态设置为" + ChatColor.YELLOW + "开启");
                            }
                            return true;
                        }
                    } catch (Exception b) {
                        sender.sendMessage(ChatColor.RED + "[EmeraldsTools] 插件发生异常，请将此消息报告于EmeraldsEgg");
                        sender.sendMessage(ChatColor.RED + "[EmeraldsTools] 错误代码: CODE_IN_FLY_63");
                        return true;
                    }
                } else {
                    sender.sendMessage("§c[EmeraldTools]此命令无法在控制台执行!");
                    return true;
                }
            }
            return false;
        } catch (Exception e){
            sender.sendMessage("§c[EmeraldTools] 玩家获取失败!");
            return true;
        }
    }
}
