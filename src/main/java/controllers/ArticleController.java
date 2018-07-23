package controllers;

import db.ArticleHelper;
import db.DBHelper;
import models.Article;
import models.Category;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ArticleController {

    public ArticleController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/articles", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/articles/index.vtl");
            List<Article> articles = ArticleHelper.getAll();

            model.put("articles", articles);
            List<Article> featurearticles = ArticleHelper.getAll();
            model.put("featurearticles", featurearticles);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("editor/articles", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/articles/editor/index.vtl");
            List<Article> articles = ArticleHelper.getAll();
            model.put("articles", articles);
            return new ModelAndView(model, "templates/editorlayout.vtl");
        }, velocityTemplateEngine);

        get("/editor/articles/new", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            List<Category> categories = Arrays.asList(Category.values());
            String date = String.valueOf(java.time.LocalDate.now());
            model.put("journalists", journalists);
            model.put("date", date);
            model.put("categories", categories);
            model.put("template", "templates/articles/editor/create.vtl");
            return new ModelAndView(model, "templates/editorlayout.vtl");
        }, velocityTemplateEngine);

        post("/editor/articles", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            String title = request.queryParams("title");
            String summary = request.queryParams("summary");
            String[] dateParts = request.queryParams("date").split("-");
            java.util.Date date = new Date((Integer.parseInt(dateParts[0]) - 1900), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
            String contentBreakless = request.queryParams("content");
            String content = contentBreakless.replace("\n", "</p><p>\n");
            Journalist journalist = DBHelper.find(Integer.valueOf(request.queryParams("journalist")), Journalist.class);
            String image = request.queryParams("image");
            int categoryValue = Integer.parseInt(request.queryParams("category"));

            Category category = Category.values()[categoryValue];

            Article newArticle = new Article(title, summary, date, content, journalist, image, category);
            DBHelper.save(newArticle);
            response.redirect("/");
            return null;
        }, velocityTemplateEngine);

        post("editor/articles/:id/delete", (request, response) -> {
            DBHelper.delete(DBHelper.find(Integer.parseInt(request.params("id")), Article.class));
            response.redirect("/editor/articles");
            return null;
        }, velocityTemplateEngine);

        get("editor/articles/:id/edit", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> journalist = DBHelper.getAll(Journalist.class);
            List<Category> categories = Arrays.asList(Category.values());
            Article article = DBHelper.find(Integer.parseInt(request.params("id")), Article.class);
            String articleDateTime = String.valueOf(article.getDate());
            String[] articleDateParts = articleDateTime.split(" ");
            String articleDate = articleDateParts[0];
            model.put("article_date", articleDate);
            model.put("article", article);
            model.put("journalists", journalist);
            model.put("categories", categories);
            model.put("template", "templates/articles/editor/update.vtl");
            return new ModelAndView(model, "templates/editorlayout.vtl");
        }, velocityTemplateEngine);

        post("editor/articles/:id", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            String title = request.queryParams("title");
            String summary = request.queryParams("summary");
            String[] dateParts = request.queryParams("date").split("-");
            Date date = new Date((Integer.parseInt(dateParts[0]) - 1900), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
            String contentBreakless = request.queryParams("content");
            String content = contentBreakless.replace("\n", "</p><p>\n");
            Journalist journalist = DBHelper.find(Integer.valueOf(request.queryParams("journalist")), Journalist.class);
            String image = request.queryParams("image");
            int categoryValue = Integer.parseInt(request.queryParams("category"));
            Category category = Category.values()[categoryValue];
            Article newArticle = new Article(title, summary, date, content, journalist, image, category);
            newArticle.setId(Integer.parseInt(request.params("id")));
            DBHelper.update(newArticle);
            response.redirect("/editor/articles");
            return null;
        }, velocityTemplateEngine);

        get("/articles/:id", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/articles/show.vtl");
            Article article = DBHelper.find(Integer.valueOf(request.params("id")), Article.class);
            model.put("article", article);
            List<Article> featurearticles = ArticleHelper.getAll();
            model.put("featurearticles", featurearticles);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);




    }
}
