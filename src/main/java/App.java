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
      model.put("location", request.session().attribute("location"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/location", (request, response)-> {
      Map<String, Object> model = new HashMap<String, Object>();

      String location = request.queryParams("location");
      Place newPlace = new Place(location);
      request.session().attribute("location", newPlace);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
