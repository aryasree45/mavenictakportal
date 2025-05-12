package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public WebDriver driver; 
	Properties prop;
	
	public void loadprop() throws IOException {
		FileInputStream propbj=new FileInputStream("C:\\Git\\mavenictakportal\\mavenictakportal\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(propbj);
	}
	
	@BeforeTest
	public void preConditions() throws IOException {
		loadprop();
		driver=new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
}
