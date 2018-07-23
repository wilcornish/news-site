package controllers;

import db.ArticleHelper;
import db.DBHelper;
import db.Seeds;
import models.Article;
import models.Category;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {
        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);
        Seeds.seedData();

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        staticFileLocation("/public");

        ArticleController articleController = new ArticleController();
        JournalistController journalistController = new JournalistController();
        EditorController editorController = new EditorController();
        CategoryController categoryController = new CategoryController();

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/home.vtl");
            List<Article> articles = ArticleHelper.getAll();
            model.put("articles", articles);
            List<Article> featurearticles = ArticleHelper.getSidebar();
            model.put("featurearticles", featurearticles);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);
    }

}

