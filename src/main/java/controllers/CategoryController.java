package controllers;

import db.DBHelper;
import models.Article;
import models.Category;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class CategoryController {

    public CategoryController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        //        get("/articles/category/:categoryName", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            model.put("template", "templates/articles/category.vtl");
//            Category category = Category.findByName("categoryName");
//            List<Article> categoryArticles = DBHelper.getArticlesByCategory(category);
//            model.put("categoryArticles", categoryArticles);
//            model.put("category", category);
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, velocityTemplateEngine);

        get("/articles/category/science", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/articles/category.vtl");
            List<Article> articles = DBHelper.getArticlesByCategory(Category.SCIENCE);
            Category category = Category.SCIENCE;
            model.put("articles", articles);
            model.put("category", category);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

    }
}

