package models;

import models.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleTest {

    Article article;
    Journalist journalist;
    Date date = new Date(1532006280);
//    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
//    String stringDate = "20/10/18";
//    Date newDate = dateFormat.parse(stringDate);


    @BeforeEach
    public void setup(){
        journalist = new Journalist("Dave Cornelius", "Dave Cornelius is a made up journalist", "@DCornelius", "DaveCornelius.jpg");
        article = new Article("Article Title", "Article summary", date, "Article content", journalist, "image.jpg");
    }

    @Test
    void getId() {
        assertEquals(0, article.getId());
    }

    @Test
    void setId() {
        article.setId(1);
        assertEquals(1, article.getId());
    }

    @Test
    void getTitle() {
        assertEquals("Article Title", article.getTitle());
    }

    @Test
    void setTitle() {
        article.setTitle("New Title");
        assertEquals("New Title", article.getTitle());
    }

    @Test
    void getSummary() {
        assertEquals("Article Summary", article.getSummary());
    }

    @Test
    void setSummary() {
        article.setSummary("New summary");
        assertEquals("New summary", article.getSummary());
    }

    @Test
    void getDate() {
        assertEquals(date, article.getDate());
    }

    @Test
    void setDate() {
        Date newDate = new Date(1532006285);
        article.setDate(newDate);
        assertEquals(newDate, article.getDate());

    }

    @Test
    void getContent() {
        assertEquals("Article content", article.getContent());
    }

    @Test
    void setContent() {
        article.setContent("New content");
        assertEquals("New content", article.getContent());
    }

    @Test
    void getJournalist() {
        assertEquals(journalist, article.getJournalist());
    }

    @Test
    void setJournalist() {
        Journalist journalist2 = new Journalist("John", "Bio", "Twitter", "picture.jpg");
        article.setJournalist(journalist2);
        assertEquals(journalist2, article.getJournalist());
    }

    @Test
    void getImage() {
        assertEquals("image.jpg", article.getImage());
    }

    @Test
    void setImage() {
        article.setImage("newimage.jpg");
        assertEquals("newimage.jpg", article.getImage());
    }
}
