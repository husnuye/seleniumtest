package testinumgittidiyor.testselenium;


import java.sql.Driver;

import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;

//import java.io.File;
import java.io.FileWriter; 
import org.openqa.selenium.support.ui.Select;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//import java.io.IOException;




public class App {
	
	public WebDriver driver = null;

    private final Logger logger = Logger.getLogger(this.getClass());
	
	public void login(){
		
		try {
	


        //www.gittigidiyor.com sitesi açılır//
        
		
		//Ana sayfanın açıldığı kontrol edilir. 
		String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("https://www.gittigidiyor.com"));
        System.out.println(URL);
        Thread.sleep(3000);
        logger.info("Gittigidyor ana sayfası açıldı");
        //*Siteye login olunur//
     
        driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[1]/div/svg/path")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div[1]/div[3]/div/div[1]/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("L-UserNameField")).sendKeys("test");
        Thread.sleep(3000);
        driver.findElement(By.id("L-PasswordField")).sendKeys("test123");
        Thread.sleep(3000);
        logger.info("Login işlemi tamamlandı");
        
        // captcha butonu
        //driver.findElement(By.class("recaptcha-checkbox-checkmark")).sendKeys("test123");
        // login butonu
        
      //Login işlemi kontrol edilir.
        
        
        String actualString =driver.findElement(By.className("gekhq4-3 icMLoL")).getText(); 
        Thread.sleep(3000);
        String expectedString = "test";
        assertTrue(actualString.contains(expectedString));
        //assertTrue(actualString.contains("test"));
        Thread.sleep(3000);
        logger.info("Login işlemi kontrol edilir");
		}
        
        catch(Exception e)	
        {
        	logger.error(e.getMessage(), e);
        }
        
        
		}
    
    
    //@Testsearch
    	
    public void SearchOrder(){
    	
    	try {
   		 
    		//1)Arama kutucuğuna bilgisayar kelimesi girilir
    	driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input")).sendKeys("Bilgisayar");
    	Thread.sleep(3000);	
    	logger.info("Arama kutucuğuna bilgisayar kelimesi girildi");
    	
    		//Arama sonuçları sayfasından 2.sayfa açılır
    	driver.findElement(By.className("desktop")).click();
    	Thread.sleep(3000);
    	logger.info("Arama kutucuğuna bilgisayar kelimesi girildi");
    	
    	//*[@id="header_wrapper"]/div[1]
    		//2.sayfanın açıldığı kontrol edilir.
    	
    	Assert.assertTrue(driver.findElement(By.className("desktop")).isSelected());
    	logger.info("2.sayfanın açıldığı kontrol edildi");	
    	
    		//Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
    	driver.findElement(By.className("title r-onepp-title")).click();
    	Thread.sleep(3000);
    	logger.info("Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir");		
    		//Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır
    	
    	//String ProductInformation = driver.findElement(By.className("gg-w-24 gg-d-24 gg-t-24 gg-m-24 pl0 pr0 product-info-details")).getText();
    	
    	String ProductInformation = driver.findElement(By.className("gg-w-24 gg-d-24 gg-t-24 gg-m-24 pl0 pr0 product-info-details")).getText();
    	Thread.sleep(3000);
    	
    	logger.info("Ürün text bilgisi alındı");	
    	//FileWriter ProductInfonfile = new FileWriter("abc.txt");
    	
    try {
    	
    	//String ProductInformation = driver.findElement(By.className("gg-w-24 gg-d-24 gg-t-24 gg-m-24 pl0 pr0 product-info-details")).getText();
    	FileWriter ProductInfonfile = new FileWriter("abc.txt");
    	//File FL  = new FileWriter(productInformation);
    	ProductInfonfile.write(ProductInformation);  
    	ProductInfonfile.close();
    	Thread.sleep(3000);
    	logger.info("Ürün text bilgisi dosyaya yazıldı");	
    	
    }
    catch(Exception e)	
    {
    	logger.error(e.getMessage(), e);	
    }
    
   
  
  
  		    //Seçilen ürün sepete eklenir.
    
  		driver.findElement(By.id("add-to-basket")).click();
  		Thread.sleep(3000);
  		logger.info("Seçilen ürün sepete eklenir.");	
  		
  		    // Ürün sayfasındaki fiyat ile sepetteki fiyatın karşılaştırılması 
  		    
  		String FirstPrice = driver.findElement(By.className("desktop")).getText();
  		Thread.sleep(3000);
  		String SecondPrice=driver.findElement(By.id("sp-price-highPrice" )).getText();
  		Assert.assertEquals(FirstPrice, SecondPrice);
  		Thread.sleep(3000);
  		logger.info("Ürün sayfasındaki fiyat ile sepetteki fiyatın karşılaştırıldı.");	
  		    
  		   
          
            //Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
  		
  		WebElement solutions_dropdown = driver.findElement(By.id("developers-menu-toggle"));
  		Thread.sleep(3000);
  		Select solutions = new Select(solutions_dropdown);
  		//solutions.selectByValue("4000");
  		solutions.selectByIndex(2);
  		Thread.sleep(3000);
  		logger.info("Sepetteki urun arttırılarak, ürün adedinin 2 yapılır");	
         
            // urun adedi 2 olduğu dogrulanır.
 
  
  		
         String actualString =driver.findElement(By.className("gg-d-16 detail-text")).getText();
         Thread.sleep(3000);   
         String expectedString = "Ürün Toplamı (2 Adet)";
         Thread.sleep(3000);
         assertTrue(actualString.contains(expectedString));
         logger.info("Sepetteki urun adedi 2 olduğu dogrulandı. ");	
         //assertTrue(actualString.contains("Ürün Toplamı (2 Adet)"));
         
         //Thread.sleep(3000);
            
            //Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
            
            // sepetteki üürnlerin silinmesi.
           
        
      
      
           driver.findElement(By.className("gg-icon gg-icon-bin-medium")).click();
           Thread.sleep(3000);
           logger.info("sepetteki ürünlerin silindi.");	
            
            // Sepetin boş olduğu kontrol edilir
            
            
            
            String actualString2 =driver.findElement(By.className("gg-w-22 gg-d-22 gg-t-21 gg-m-18")).getText();
            Thread.sleep(3000);
            String expectedString2 = ("Sepetinizde ürün bulunmamaktadır.");
            Thread.sleep(3000);
            assertTrue(actualString2.contains(expectedString2));
            logger.info("Sepetin boş olduğu kontrol edilir");	
            
            //assertTrue(actualString.contains("Sepetinizde ürün bulunmamaktadır."));
            
            //Thread.sleep(3000);
            
           
           ////
            
        }
        
        catch(Exception e)	
        {
    		 //System.out.println(e);	
    		 logger.error(e.getMessage(), e);
        }
        
        
		}

	
	
	}
