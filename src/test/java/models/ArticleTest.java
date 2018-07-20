package models;

import models.Article;
import net.sf.cglib.core.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleTest {

    Article article;
    Journalist journalist;
    LocalDate date = LocalDate.of(20, 4,18);
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
    }

    @Test
    void setId() {
    }

    @Test
    void getTitle() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void getSummary() {
    }

    @Test
    void setSummary() {
    }

    @Test
    void getDate() {
        assertEquals(date, article.getDate());
    }

    @Test
    void setDate() {
    }

    @Test
    void getContent() {
    }

    @Test
    void setContent() {
    }

    @Test
    void getJournalist() {
    }

    @Test
    void setJournalist() {
    }

    @Test
    void getImage() {
    }

    @Test
    void setImage() {
    }
}
