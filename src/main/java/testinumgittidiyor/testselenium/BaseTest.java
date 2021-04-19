package testinumgittidiyor.testselenium;



import org.apache.log4j.Logger;
import org.junit.Assert;
//import org.test

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public WebDriver driver = null;
    private final Logger logger = Logger.getLogger(this.getClass());

    public void baslangic(){
        
        try {
        	System.setProperty("webdriver.chrome.driver", "src/test/resources/85/chromedriver.exe");
            driver = new ChromeDriver();
            
        	String URL = driver.getCurrentUrl();
            Assert.assertTrue(URL.contains("https://www.gittigidiyor.com"));
            //System.out.println(URL);
            Thread.sleep(3000);
        } catch  (Exception e) {
 
            System.out.println("Gitti gidiyor ana sayfa açılmadı");}
            }
        
        //AssertEquals(expected title, driver.gettitle());}


     public void bitis(){

        driver.quit();
    }

}