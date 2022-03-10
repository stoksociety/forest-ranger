import models.Animal;
import models.Sighting;
import org.sql2o.Sql2o;
import real.Sql20Animalreal;
import real.Sql20Sightingreal;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        String connection = "jdbc:postgresql://ec2-3-225-79-57.compute-1.amazonaws.com:5432/dd1r4d2ofaup6n?sslmode=require";
        Sql2o sql2o = new Sql2o(connection, "jtxvgzzwskkqjc", "bbac89e2b6f957c19ec56182ed627c570c34f5bcba9fd24aff39618ab8b25412");

        Sql20Animalreal sql2oAnimalreal = new Sql20Animalreal(sql2o);
        Sql20Sightingreal  sql2oSightingreal = new Sql20Sightingreal(sql2o);

        //Root route
        get("/index.hbs", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = sql2oAnimalreal.getAll();
            List<Sighting> sightings = sql2oSightingreal.getAll();
            model.put("animals", animals);
            model.put("sightings", sightings);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //Add new animal route
        post("/addAnimal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String health = request.queryParams("health");

            if (request.queryParams("endangeredInput") != null) {
                if (!(name.trim().isEmpty() || age.trim().isEmpty() || health.trim().isEmpty())) {
                    Animal animals = new Animal(name, age, health);
                    sql2oAnimalreal.add(animals);
                } else {
                    System.out.println("If Endangered, Fill in all The Extra Fields!!");
                }
            } else {
                Animal animals = new Animal(name, age, health);
                sql2oAnimalreal.add(animals);
            }
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        post("/addSighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = sql2oAnimalreal.getAll();

            String id = request.queryParams("id");
            int newId = Integer.parseInt(id);
            String name = animals.get(newId - 1).name;
            String age = animals.get(newId - 1).age;
            String health = animals.get(newId - 1).health;
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            Sighting sightings = new Sighting(name, age, health, location, rangerName);
            sql2oSightingreal.add(sightings);

            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
    }
}
