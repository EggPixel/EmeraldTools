package cn.eggpixel.API;

import java.util.ArrayList;
import java.util.List;

public class VanishEnabledOr {
    private static List<String> vanishes = new ArrayList<>();
    public boolean Vanish(String player) {
        if (vanishes.contains(player)) {
            vanishes.remove(player);
            return false;
        }
        else {
            vanishes.add(player);
            return true;
        }
    }
    public boolean Vanishes(String player) {
        if (vanishes.contains(player)) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean remove(String player) {
        if (!vanishes.contains(player)) {
            return false;
        }
        else {
            return true;
        }
    }
}
