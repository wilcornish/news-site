package controllers;

import db.DBHelper;
import models.*;
import models.Article;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.delete;
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
            List<Article> articles = DBHelper.getAll(Article.class);
            model.put("articles", articles);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/articles/new", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> journalist = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalist);
            model.put("template", "templates/articles/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/articles", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            String title = request.queryParams(title);
            String summary = request.queryParams(summary);
            Date date = new Date(Integer.parseInt(request.queryParams(date)));
            String content = request.queryParams(content);
            Journalist journalist = DBHelper.find(Integer.valueOf(request.queryParams("journalist")), Journalist.class);
            String image = request.queryParams(image);
            Article newArticle = new Article(title, summary, date, content, journalist, image);
            DBHelper.save(newArticle);
            response.redirect("/articles");
            return null;
        }, velocityTemplateEngine);

        post("/articles/:id/delete", (request, response) -> {
            DBHelper.delete(DBHelper.find(Integer.parseInt(request.params("id")), Article.class));
            response.redirect("/articles");
            return null;
        }, velocityTemplateEngine);

        get("/articles/:id/edit", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> journalist = DBHelper.getAll(Journalist.class);
            model.put("article", DBHelper.find(Integer.parseInt(request.params("id")), Article.class));
            model.put("journalists", journalist);
            model.put("template", "templates/articles/update.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/articles/:id", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            String title = request.queryParams(title);
            String summary = request.queryParams(summary);
            Date date = new Date(Integer.parseInt(request.queryParams(date)));
            String content = request.queryParams(content);
            Journalist journalist = DBHelper.find(Integer.valueOf(request.queryParams("journalist")), Journalist.class);
            String image = request.queryParams(image);
            Article newArticle = new Article(title, summary, date, content, journalist, image);
            newArticle.setId(Integer.parseInt(request.params("id")));
            DBHelper.update(newArticle);
            response.redirect("/articles");
            return null;
        }, velocityTemplateEngine);

        get("/articles/:id", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/articles/index.vtl");
            Article article = DBHelper.find(Integer.valueOf(request.params("id")), Article.class);
            model.put("article", article);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);
    }
}
