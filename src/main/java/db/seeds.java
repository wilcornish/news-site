package db;

import models.Journalist;

public class seeds {

    public static void seedData() {
        Journalist journalist1 = new Journalist("Dave Cornelius", "Dave Cornelius is a made up journalist", "@DCornelius", "DaveCornelius.jpg");
        Journalist journalist2 = new Journalist("Spider Jerusalem", "Spider Jerusalem is a figment of Warren Ellis' Imagination", "@SJerusalem", "SpiderJerusalem.jpg");
        DBHelper.save(journalist1);
        DBHelper.save(journalist2);
    }
}
