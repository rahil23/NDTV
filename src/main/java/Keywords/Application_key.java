package Keywords;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




public class Application_key extends Generic_key {

	public Application_key() throws IOException {
		String Path = System.getProperty("user.dir") + "//src//test//resources//prod.properties";
		prop = new Properties();

		FileInputStream fs = new FileInputStream(Path);
		prop.load(fs);

	}

	public void checkbox(String locatorKey, String data) {
		String checkCity = prop.getProperty(data);
		List<WebElement> checked = driver.findElements(By.cssSelector(prop.getProperty(locatorKey)));
		System.out.println("Total no. of checkbox " + checked.size());
		for (int i = 0; i < checked.size(); i++) {
			if (checked.get(i).getAttribute("id").equals(checkCity)) {
				System.out.println("Jalandhar is clicked---" + checked.get(i).getAttribute("id"));
				checked.get(i).click();
				break;
			}
		}

	}

	public String tempCity(String locatorKey, String data)
	{
		String mapTemperature="";	
		String checkTempCity=prop.getProperty(locatorKey);
		String checkCity=prop.getProperty(data);	
		checkTempCity=checkTempCity.replaceAll("#city#", checkCity);
		 mapTemperature= driver.findElement(By.xpath(checkTempCity)).getText();
	
		return mapTemperature;
	
	
	}
	public void clickLinkText(String text)
	{
		driver.findElement(By.linkText(text)).click();
}
}
