package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JournalistTest {
    Journalist journalist;

    @BeforeEach
    void setUp() {
        journalist = new Journalist("Dave Cornelius", "Dave Cornelius is a made up journalist", "@DCornelius", "DaveCornelius.jpg");
    }

    @Test
    void getId() {
       assertEquals(0, journalist.getId());
    }

    @Test
    void setId() {
        journalist.setId(1);
        assertEquals(1, journalist.getId());
    }

    @Test
    void getName() {
        assertEquals("Dave Cornelius", journalist.getName());
    }

    @Test
    void setName() {
        journalist.setName("Quentin Travers");
        assertEquals("Quentin Travers", journalist.getName());
    }

    @Test
    void getBio() {
        assertEquals("Dave Cornelius is a made up journalist", journalist.getBio());
    }

    @Test
    void setBio() {
        journalist.setBio("Dave Cornelius saw the Battle Beast");
        assertEquals("Dave Cornelius saw the Battle Beast", journalist.getBio());
    }

    @Test
    void getTwitter() {
        assertEquals("@DCornelius", journalist.getTwitter());
    }

    @Test
    void setTwitter() {
        journalist.setTwitter("@DaveCornelius");
        assertEquals("@DaveCornelius", journalist.getTwitter());
    }

    @Test
    void getPicture() {
        assertEquals("DaveCornelius.jpg", journalist.getPicture());
    }

    @Test
    void setPicture() {
        journalist.setPicture("dave.jpg");
        assertEquals("dave.jpg", journalist.getPicture());
    }

    @Test
    void getArticles() {
        assertEquals(0, journalist.getArticles().size());
    }

    @Test
    void setArticles() {
        LocalDate date = LocalDate.of(20,10, 17);
        Article article = new Article("Article Title", "Article summary", date, "Article content", journalist, "image.jpg");
        ArrayList<Article> articlelist = new ArrayList<Article>();
        articlelist.add(article);
        journalist.setArticles(articlelist);
       assertEquals(1, journalist.getArticles().size());
    }
}