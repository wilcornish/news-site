package controllers;

import db.DBHelper;
import db.Seeds;
import models.Article;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {
        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        staticFileLocation("/public");

        Seeds.seedData();
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/home.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);
    }
}
