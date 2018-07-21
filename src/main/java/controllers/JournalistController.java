package controllers;

import db.DBHelper;
import models.Article;
import models.Journalist;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class JournalistController {

    public JournalistController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/editor/journalists", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/journalists/editor/index.vtl");
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/editor/journalists/new", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);
            model.put("template", "templates/journalists/editor/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/editor/journalists", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String bio = request.queryParams("bio");
            String twitter = request.queryParams("twitter");
            String picture = request.queryParams("picture");
            Journalist newJournalist = new Journalist(name, bio, twitter, picture);
            DBHelper.save(newJournalist);
            response.redirect("/editor/journalists");
            return null;
        }, velocityTemplateEngine);

        post("/editor/journalists/:id/delete", (request, response) -> {
            DBHelper.delete(DBHelper.find(Integer.parseInt(request.params("id")), Journalist.class));
            response.redirect("/editor/journalists");
            return null;
        }, velocityTemplateEngine);

        get("editor/journalists/:id/edit", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int journalistId = Integer.parseInt(req.params(":id"));
            Journalist selectedJournalist = DBHelper.find(journalistId, Journalist.class);
            model.put("journalist", selectedJournalist);
            model.put("template", "templates/journalists/editor/edit.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        post("/editor/journalists/:id", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String bio = request.queryParams("bio");
            String twitter = request.queryParams("twitter");
            String picture = request.queryParams("picture");
            Journalist newJournalist = new Journalist(name, bio, twitter, picture);
            newJournalist.setId(Integer.parseInt(request.params("id")));
            DBHelper.update(newJournalist);
            response.redirect("/editor/journalists");
            return null;
        }, velocityTemplateEngine);

        get("/journalists", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/journalists/index.vtl");
            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
            model.put("journalists", journalists);

            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("journalists/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Journalist journalist = DBHelper.find(intId, Journalist.class);
            List<Article> articles = DBHelper.getArticlesForJournalist(journalist);
            Map<String, Object> model = new HashMap<>();
            model.put("journalist", journalist);
            List<Article> featurearticles = DBHelper.getAll(Article.class);
            model.put("featurearticles", featurearticles);
            model.put("articles", articles);
            model.put("template", "templates/journalists/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());
    }
}
