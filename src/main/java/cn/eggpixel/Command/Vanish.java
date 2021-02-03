package cn.eggpixel.Command;

import cn.eggpixel.EmeraldTools;
import cn.eggpixel.API.VanishEnabledOr;
import cn.eggpixel.API.getMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Iterator;


public class Vanish implements CommandExecutor {
    private final EmeraldTools plugin;

    public Vanish(EmeraldTools plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        try {
            if (args.length == 1) {
                Player player = Bukkit.getPlayerExact(args[0]);
                PotionEffect potionEffect = PotionEffectType.INVISIBILITY.createEffect(1000000000, 2);
                PotionEffectType potionType = PotionEffectType.INVISIBILITY;
                Iterator var2;
                var2 = Bukkit.getOnlinePlayers().iterator();
                if (new VanishEnabledOr().Vanishes(player.getName())) {
                    player.addPotionEffect(potionEffect);
                    player.sendMessage(new getMessages().VANISH_ON.replace("%PLAYERNAME%", player.getName()));
                }
                else {
                    player.removePotionEffect(potionType);
                    player.sendMessage(new getMessages().VANISH_OFF.replace("%PLAYERNAME%", player.getName()));
                }
                while (var2.hasNext()) {
                    Player user = (Player) var2.next();
                    if (!user.hasPermission("emeraldtools.vanish.see")) {
                        if (new VanishEnabledOr().Vanish(player.getName())) {
                            user.hidePlayer(plugin, player);
                        }
                        else {
                            user.showPlayer(plugin, player);
                        }
                    }
                }
                return true;
            }
            if (args.length == 0) {
                if (sender instanceof Player) {
                    Player player = ((Player) sender).getPlayer();
                    PotionEffect potionEffect = PotionEffectType.INVISIBILITY.createEffect(1000000000, 2);
                    PotionEffectType potionType = PotionEffectType.INVISIBILITY;
                    Iterator var2;
                    var2 = Bukkit.getOnlinePlayers().iterator();
                    if (new VanishEnabledOr().Vanish(player.getName())) {
                        player.addPotionEffect(potionEffect);
                        player.sendMessage(new getMessages().VANISH_ON.replace("%PLAYERNAME%", player.getName()));
                    }
                    else {
                        player.removePotionEffect(potionType);
                        player.sendMessage(new getMessages().VANISH_OFF.replace("%PLAYERNAME%", player.getName()));
                    }
                    while (var2.hasNext()) {
                        Player user = (Player) var2.next();
                        if (!user.hasPermission("emeraldtools.vanish.see")) {
                            if (!new VanishEnabledOr().Vanishes(player.getName())) {
                                user.hidePlayer(plugin, player);
                            }
                            else {
                                user.showPlayer(plugin, player);
                            }
                        }
                    }
                } else {
                    sender.sendMessage(new getMessages().DO_IN_CONSOLE);
                }
                return true;
            }
            return false;
        } catch (Exception e){
            sender.sendMessage(new getMessages().PLAYER_NOT_FOUND);
            return true;
        }
    }
}
