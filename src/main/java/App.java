import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("locations", request.session().attribute("locations"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/location", (request, response)-> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Place> locationsArray = request.session().attribute("locations");

      if(locationsArray == null) {
        locationsArray = new ArrayList<Place>();
        request.session().attribute("locations", locationsArray);
      }

      String location = request.queryParams("locations");
      Place newPlace = new Place(location);
      locationsArray.add(newPlace);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
