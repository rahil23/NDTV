package Project_script;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Keywords.InvalidTempDiffException;

public class Ndtv extends BaseeTest{

	@Test
	public void ValidateTempDiff() throws InterruptedException
	{   	
		app.click("subMenu_css");
		app.clickLinkText("WEATHER");
		app.type("search_xpath","searchData");
		app.click("mapClick_id");
		
		app.checkbox("checkbox_css","searchData");
		String map_temp=app.tempCity("temp_xpath","searchData");
		map_temp=map_temp.substring(0, 2);
		float mapTemperature=Float.parseFloat(map_temp);
		
		WeatherAPI api = new WeatherAPI();
		float api_temp=api.callAPI();
		
		float tempDiff= mapTemperature-api_temp;
		
		if(tempDiff<=2)
		{
			Assert.assertTrue(true,"Test Case is Passed");
		}
		else
		{
			try {
				throw new InvalidTempDiffException("This Difference of Temperature b/w Website and APi is not valid");
			} catch (InvalidTempDiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
}
