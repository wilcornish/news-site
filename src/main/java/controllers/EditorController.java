package controllers;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;


public class EditorController {
    public EditorController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/login", (request, response) ->

        {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/login.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/login", (request, response) ->

        {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/login.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/editor", (request, response) ->

        {
            response.redirect("/editor/articles");
            return null;
        });

    }
}