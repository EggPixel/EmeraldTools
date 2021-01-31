package cn.eggpixel;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public class EmeraldTools extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        YamlConfiguration message = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "message.yml"));
        saveResource("message.yml",false);
        Bukkit.getPluginManager().registerEvents(this,this);
        Bukkit.getPluginManager().registerEvents(new PlayerLogin(),this);
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools] ===================");
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools]     插件已成功加载!   ");
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools] ===================");
        this.getCommand("kills").setExecutor(new Kills(this));
        this.getCommand("kill").setExecutor(new Kill(this));
        this.getCommand("fly").setExecutor(new Fly(this));
        this.getCommand("v").setExecutor(new Vanish(this));
        this.getCommand("vanish").setExecutor(new Vanish(this));
    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools] ===================");
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools]       插件已关闭!    ");
        Bukkit.getConsoleSender().sendMessage("§a[EmeraldTools] ===================");
    }
}
