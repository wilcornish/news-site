package db;

import models.Article;
import models.Journalist;

import java.time.LocalDate;
import java.util.Date;

public class Seeds {

    public static void seedData() {
        LocalDate date1 = LocalDate.of(2018,10, 17);
        LocalDate date2 = LocalDate.of(2018,10, 18);
        Journalist journalist1 = new Journalist("Dave Cornelius", "Dave Cornelius is a made up journalist", "@DCornelius", "DaveCornelius.jpg");
        Journalist journalist2 = new Journalist("Spider Jerusalem", "Spider Jerusalem is a figment of Warren Ellis' Imagination", "@SJerusalem", "SpiderJerusalem.jpg");
        DBHelper.save(journalist1);
        DBHelper.save(journalist2);

        Article article1 = new Article("Article Title", "Article summary", date1, "Article content", journalist1, "image.jpg");
        Article article2 = new Article("Different Title", "Different summary", date2, "different content", journalist2, "image2.jpg");
        DBHelper.save(article1);
        DBHelper.save(article2);
    }
}
//