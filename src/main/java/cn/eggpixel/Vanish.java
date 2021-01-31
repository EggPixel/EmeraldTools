package cn.eggpixel;

import cn.eggpixel.api.VanishEnabledOr;
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
                while (var2.hasNext()) {
                    Player user = (Player) var2.next();
                    if (!user.hasPermission("emeraldtools.vanish.see")) {
                        if (new VanishEnabledOr().VanishEnabledOr(player.getName())) {
                            player.addPotionEffect(potionEffect);
                            player.sendMessage("§a[EmeraldTools] 您已隐身");
                            user.hidePlayer(plugin, player);
                        }
                        else {
                            player.removePotionEffect(potionType);
                            player.sendMessage("§a[EmeraldTools] 您已取消隐身");
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
                    while (var2.hasNext()) {
                        Player user = (Player) var2.next();
                        if (!user.hasPermission("emeraldtools.vanish.see")) {
                            if (new VanishEnabledOr().VanishEnabledOr(player.getName())) {
                                player.addPotionEffect(potionEffect);
                                player.sendMessage("§a[EmeraldTools] 您已隐身");
                                user.hidePlayer(plugin, player);
                            }
                            else {
                                player.removePotionEffect(potionType);
                                player.sendMessage("§a[EmeraldTools] 您已取消隐身");
                                user.showPlayer(plugin, player);
                            }
                        }
                    }
                } else {
                    plugin.getLogger().warning("此命令无法在控制台执行!");
                }
                return true;
            }
            return false;
        } catch (Exception e){
            sender.sendMessage("§c[EmeraldTools] 玩家获取失败!");
            return true;
        }
    }
}
