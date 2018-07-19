package controllers;

import db.Seeds;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {
//        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
//        staticFileLocation("/public");

//        Seeds.seedData();
        get("/hello", (req, res) -> {return "Hello";});
    }
}
