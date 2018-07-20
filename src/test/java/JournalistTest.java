import models.Article;
import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class JournalistTest {
    Journalist journalist;

    @Before
    public void setUp() {
        journalist = new Journalist("Dave Cornelius", "Dave Cornelius is a made up journalist", "@DCornelius", "DaveCornelius.jpg");
    }

    @Test
    public void getId() {
        assertEquals(0, journalist.getId());
    }

    @Test
    public void setId() {
        journalist.setId(1);
        assertEquals(1, journalist.getId());
    }

    @Test
    public void getName() {
        assertEquals("Dave Cornelius", journalist.getName());
    }

    @Test
    public void setName() {
        journalist.setName("Quentin Travers");
        assertEquals("Quentin Travers", journalist.getName());
    }

    @Test
    public void getBio() {
        assertEquals("Dave Cornelius is a made up journalist", journalist.getBio());
    }

    @Test
    public void setBio() {
        journalist.setBio("Dave Cornelius saw the Battle Beast");
        assertEquals("Dave Cornelius saw the Battle Beast", journalist.getBio());
    }

    @Test
    public void getTwitter() {
        assertEquals("@DCornelius", journalist.getTwitter());
    }

    @Test
    public void setTwitter() {
        journalist.setTwitter("@DaveCornelius");
        assertEquals("@DaveCornelius", journalist.getTwitter());
    }

    @Test
    public void getPicture() {
        assertEquals("DaveCornelius.jpg", journalist.getPicture());
    }

    @Test
    public void setPicture() {
        journalist.setPicture("dave.jpg");
        assertEquals("dave.jpg", journalist.getPicture());
    }

    @Test
    public void getArticles() {
        assertEquals(0, journalist.getArticles().size());
    }

    @Test
    void setArticles() {
        Date date = new Date(2018, 10, 17);
        Article article = new Article("Article Title", "Article summary", date, "Article content", journalist, "image.jpg");
        ArrayList<Article> articlelist = new ArrayList<Article>();
        articlelist.add(article);
        journalist.setArticles(articlelist);
        assertEquals(1, journalist.getArticles().size());
    }
}