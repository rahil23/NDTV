package Project_script;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class WeatherAPI {

	
	public float callAPI() {

		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather";
		String appKey = "7fe67bf08c80ded756e598d6f8fedaea";

		Response res = RestAssured.given().contentType(ContentType.JSON).queryParam("q", "Jalandhar")
				.queryParam("appid", appKey).queryParam("units", "metric").log().all().get();

		res.prettyPeek();

		JsonPath json = res.jsonPath();
		float temp_map = json.get("main.temp");
		return temp_map;

	}

}
