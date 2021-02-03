package cn.eggpixel.API;

import cn.eggpixel.EmeraldTools;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class getMessages {
    public YamlConfiguration message = YamlConfiguration.loadConfiguration(new File(EmeraldTools.instance.getDataFolder(), "message.yml"));
    public String DO_IN_CONSOLE = message.getString("DO_IN_CONSOLE");
    public String PLAYER_NOT_FOUND = message.getString("PLAYER_NOT_FOUND");
    public String KILL_SUCCESSFUL = message.getString("KILL_SUCCESSFUL");
    public String LOGIN_CHAT = message.getString("LOGIN_CHAT");
    public String LOGIN_SUCCESSFUL = message.getString("LOGIN_SUCCESSFUL");
    public String VANISH_ON = message.getString("VANISH_ON");
    public String VANISH_OFF = message.getString("VANISH_OFF");
    public String FLY_OFF = message.getString("VANISH_OFF");
    public String FLY_ON = message.getString("FLY_ON");
    public String BURN_PLAYER = message.getString("BURN_PLAYER");
}
