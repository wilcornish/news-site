//package controllers;
//
//import db.DBHelper;
//import models.Journalist;
//import models.Journalist;
//import spark.ModelAndView;
//import spark.template.velocity.VelocityTemplateEngine;
//
//import java.sql.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static spark.Spark.get;
//import static spark.Spark.post;
//
//public class JournalistController {
//
//    public JournalistController() {
//        this.setupEndpoints();
//    }
//
//    private void setupEndpoints() {
//
//        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
//
//        get("/editor/journalists", (request, response) -> {
//            Map<String, Object> model = new HashMap();
//            model.put("template", "templates/journalists/editor/index.vtl");
//            List<Journalist> journalists = DBHelper.getAll(Journalist.class);
//            model.put("journalists", journalists);
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, velocityTemplateEngine);
//
//        get("/editor/journalists/new", (request, response) -> {
//            HashMap<String, Object> model = new HashMap<>();
//            List<Journalist> journalist = DBHelper.getAll(Journalist.class);
//            model.put("journalists", journalist);
//            model.put("template", "templates/journalists/editor/create.vtl");
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, velocityTemplateEngine);
//
//        post("/editor/journalists", (request, response) -> {
//            HashMap<String, Object> model = new HashMap<>();
//            String name = request.queryParams(name);
//            String bio = request.queryParams(bio);
//            String twitter = request.queryParams(twitter);
//            String picture = request.queryParams(picture);
//            Journalist newJournalist = new Journalist(name, bio, twitter, picture);
//            DBHelper.save(newJournalist);
//            response.redirect("/editor/journalists");
//            return null;
//        }, velocityTemplateEngine);
//
//        post("/editor/journalists/:id/delete", (request, response) -> {
//            DBHelper.delete(DBHelper.find(Integer.parseInt(request.params("id")), Journalist.class));
//            response.redirect("/editor/journalists");
//            return null;
//        }, velocityTemplateEngine);
//
//        get("/editor/journalists/:id/edit", (request, response) -> {
//            HashMap<String, Object> model = new HashMap<>();
//            List<Journalist> journalist = DBHelper.getAll(Journalist.class);
//            model.put("journalist", DBHelper.find(Integer.parseInt(request.params("id")), Journalist.class));
//            model.put("journalists", journalist);
//            model.put("template", "templates/journalists/editor/update.vtl");
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, velocityTemplateEngine);
//
//        post("/editor/journalists/:id", (request, response) -> {
//            HashMap<String, Object> model = new HashMap<>();
//            String name = request.queryParams(name);
//            String bio = request.queryParams(bio);
//            String twitter = request.queryParams(twitter);
//            String picture = request.queryParams(picture);
//            Journalist newJournalist = new Journalist(name, bio, twitter, picture);
//            newJournalist.setId(Integer.parseInt(request.params("id")));
//            DBHelper.update(newJournalist);
//            response.redirect("/editor/journalists");
//            return null;
//        }, velocityTemplateEngine);
//
//        get("/journalists/:id", (request, response) -> {
//            Map<String, Object> model = new HashMap();
//            model.put("template", "templates/journalists/index.vtl");
//            Journalist journalist = DBHelper.find(Integer.valueOf(request.params("id")), Journalist.class);
//            model.put("journalist", journalist);
//            return new ModelAndView(model, "templates/layout.vtl");
//        }, velocityTemplateEngine);
//    }
//}
