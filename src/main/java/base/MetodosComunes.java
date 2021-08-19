package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MetodosComunes {
	//metodo de inicializas 1. variable de clase
	WebDriver driver;
	String baseUrl;
	WebElement element;
	
	@BeforeMethod
	
	public void inicializarExplorador (String URL, String explorador) {
		switch (explorador) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
			option.addArguments("--start-maximized");

			driver = new ChromeDriver(option);
			driver.get(URL);

			break;
		
		case "msedge":
			System.setProperty("webdriver.msedge.driver", System.getProperty("user.dir") + "\\msedgedriver\\msedgedriver.exe");
			EdgeOptions option2 = new EdgeOptions();
			option2.addArguments("--incognito");
			option2.addArguments("--start-maximized");

			driver = new EdgeDriver(option2);
			driver.get(URL);

			break;
			
		case "geckodriver":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver\\geckodriver.exe");
			FirefoxOptions option3 = new FirefoxOptions();
			option3.addArguments("--incognito");
			option3.addArguments("--start-maximized");

			driver = new FirefoxDriver(option3);
			driver.get(URL);

			break;
			
		}// se cierra swicht
	}//se cierra inicializador
	
	@Test
	
	public void ingresarTexto(WebElement buscar, String texto ) {
		buscar.clear();
		buscar.sendKeys(texto);
		buscar.sendKeys(Keys.ENTER);
		Reporter.log("El texto que vas a mandar = " + texto, true);
	}
	
	public void click(WebElement click ) {
		click.click();
		Reporter.log("Se le dio click " , true);
		
	}
	public void scroll (WebElement scroll) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", scroll);
		Reporter.log("se le dio scroll al elemento", true);
	}
	
	
	public void testUnitled() throws Exception {
		driver.get(baseUrl);
		element = driver.findElement(By.id("Ist-ib"));
		element.sendKeys("Selenium WebDriver Interview questions");
		element.sendKeys(Keys.RETURN);
		List<WebElement>list = driver.findElements(By.className("_Rm"));
		System.out.println(list.size());
	}
	
	
	@AfterMethod
	
	public void tearDown() throws Exception {
		driver.quit();
		}
	
	

}//se cierra el inicializador
