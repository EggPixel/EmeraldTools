package cn.eggpixel;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import cn.eggpixel.api.getMessages;

public class Heal implements CommandExecutor {
    private final EmeraldTools plugin;
    public Heal(EmeraldTools plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        PotionEffect potionEffect = PotionEffectType.SATURATION.createEffect(20, 100);
            try {
                if (args.length == 1) {
                    Player player = Bukkit.getPlayerExact(args[0]);
                    player.setMaxHealth(20);
                    player.setHealth(20);
                    player.setSaturation(20);
                    player.addPotionEffect(potionEffect);
                    return true;
                }
                else {
                    if (!(args.length == 0)) {
                        return false;
                    }
                }
                if (sender instanceof Player) {
                    if (args.length == 0) {
                        Player player = ((Player) sender).getPlayer();
                        player.setMaxHealth(20);
                        player.setHealth(20);
                        player.setSaturation(20);
                        player.addPotionEffect(potionEffect);
                        return true;
                    }
                    else {
                        if (!(args.length == 1)) {
                            return false;
                        }
                    }
                } else {
                    sender.sendMessage(new getMessages().DO_IN_CONSOLE);
                    return true;
                }
            } catch (Exception e) {
                sender.sendMessage(new getMessages().PLAYER_NOT_FOUND);
                return true;
            }
        return false;
    }
}
