package com.demo.utils;

public class LevelUtils {
    public static String getLevel(double amt) {
        if (amt <= 50000) {
            return "13"; //四级
        } else if (amt > 50000 && amt <= 60000) {
            return "14"; //五级
        } else if (amt > 60000 && amt <= 70000) {
            return "15"; //六级
        } else if (amt > 70000 && amt <= 80000) {
            return "16"; //七级
        } else if (amt > 80000 && amt <= 90000) {
            return "17"; //八级
        } else if (amt > 90000 && amt <= 100000) {
            return "18"; //九级
        } else {
            return "19"; //十级
        }
    }
}
