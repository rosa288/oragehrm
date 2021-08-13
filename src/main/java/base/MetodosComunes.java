package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MetodosComunes {
	//metodo de inicializas 1. variable de clase
	WebDriver driver;
	
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
	
	
	

}//se cierra el inicializador
