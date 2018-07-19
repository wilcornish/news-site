import models.Article;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArticleTest {

    Article article;
    Date date = new Date();
//    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
//    String stringDate = "20/10/18";
//    Date newDate = dateFormat.parse(stringDate);


    @BeforeEach
    public void setup(){
        article = new Article("Article Title", "Article summary", )
    }
}
