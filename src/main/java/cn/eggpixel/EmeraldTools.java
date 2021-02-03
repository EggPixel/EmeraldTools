package cn.eggpixel;

import cn.eggpixel.Command.*;
import cn.eggpixel.Events.PlayerLogin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public class EmeraldTools extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        saveResource("message.yml",false);
        Bukkit.getPluginManager().registerEvents(this,this);
        Bukkit.getPluginManager().registerEvents(new PlayerLogin(),this);
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools] ===================");
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools]     插件已成功加载!   ");
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools] ===================");
        Objects.requireNonNull(this.getCommand("kills")).setExecutor(new Kills(this));
        Objects.requireNonNull(this.getCommand("kill")).setExecutor(new Kill(this));
        Objects.requireNonNull(this.getCommand("fly")).setExecutor(new Fly(this));
        Objects.requireNonNull(this.getCommand("v")).setExecutor(new Vanish(this));
        Objects.requireNonNull(this.getCommand("vanish")).setExecutor(new Vanish(this));
        Objects.requireNonNull(this.getCommand("heal")).setExecutor(new Heal(this));
        Objects.requireNonNull(this.getCommand("emeraldtools")).setExecutor(new reloadPlugin(this));
        Objects.requireNonNull(this.getCommand("burn")).setExecutor(new Burn(this));
    }
    public static Plugin instance;
    @Override
    public void onLoad(){
        instance = this;
    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools] ===================");
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools]       插件已关闭!    ");
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools] ===================");
    }
}
