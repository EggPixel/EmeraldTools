package cn.eggpixel.Command;

import cn.eggpixel.EmeraldTools;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reloadPlugin implements CommandExecutor {
    private final EmeraldTools plugin;
    public reloadPlugin(EmeraldTools plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            if (args[0] == "reload") {
                sender.sendMessage("§a[EmeraldTools] §cThis message can be hot changed directly without reloading.");
                sender.sendMessage("§a[EmeraldTools] §c消息文件可以直接热更改，不需要重新加载");
                return true;
            }
        }
        return false;
    }
}
