package cn.eggpixel.Command;

import cn.eggpixel.EmeraldTools;
import cn.eggpixel.API.getMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import java.util.UUID;

public class Kill implements CommandExecutor {
    private final EmeraldTools plugin;

    public Kill(EmeraldTools plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            try {
                Player player = Bukkit.getPlayerExact(args[0]);
                assert player != null;
                player.setHealth(0.00);
                sender.sendMessage(new getMessages().KILL_SUCCESSFUL.replace("%PLAYERNAME%", player.getName()));
                return true;
            } catch (Exception e) {
                try {
                    UUID now1 = UUID.fromString(args[0]);
                    Player player1 = Bukkit.getPlayer(now1);
                    assert player1 != null;
                    player1.setHealth(0.00);
                    return true;
                } catch (Exception b) {
                    try {
                        UUID now = UUID.fromString(args[0]);
                        Entity entity = Bukkit.getEntity(now);
                        assert entity != null;
                        entity.remove();
                        return true;
                    } catch (Exception a) {
                        sender.sendMessage(new getMessages().PLAYER_NOT_FOUND);
                        return true;
                    }
                }
            }
        }
        else {
            return false;
        }
    }
}