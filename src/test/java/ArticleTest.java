import models.Article;
import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class ArticleTest {

    Article article;
    Journalist journalist;
    Date date = new Date(1532006280);
//    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
//    String stringDate = "20/10/18";
//    Date newDate = dateFormat.parse(stringDate);


    @Before
    public void setup(){
        journalist = new Journalist("Dave Cornelius", "Dave Cornelius is a made up journalist", "@DCornelius", "DaveCornelius.jpg");
        article = new Article("Article Title", "Article summary", date, "Article content", journalist, "image.jpg");
    }

    @Test
    public void getId() {
    }

    @Test
    public  void setId() {
    }

    @Test
    public  void getTitle() {
    }

    @Test
    public  void setTitle() {
    }

    @Test
    public  void getSummary() {
    }

    @Test
    public void setSummary() {
    }

    @Test
    public void getDate() {
        assertEquals(date, article.getDate());
    }

    @Test
    public  void setDate() {
    }

    @Test
    public void getContent() {
    }

    @Test
    public void setContent() {
    }

    @Test
    public void getJournalist() {
    }

    @Test
    public void setJournalist() {
    }

    @Test
    public void getImage() {
    }

    @Test
    public  void setImage() {
    }
}
