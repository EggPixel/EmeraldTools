package cn.eggpixel.api;

import java.util.ArrayList;
import java.util.List;

public class VanishEnabledOr {
    private static List<String> vanishes = new ArrayList<>();
    public boolean VanishEnabledOr(String player) {
        if (vanishes.contains(player)) {
            vanishes.remove(player);
            return false;
        }
        else {
            vanishes.add(player);
            return true;
        }
    }
}
