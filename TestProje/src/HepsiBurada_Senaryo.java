import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HepsiBurada_Senaryo {
	static WebDriver driver;
	static Actions builder;
	static  WebDriverWait wait;
	@Test
	void test() {
		
		Class_Login login  = new Class_Login();
		AnaSayfa anasayfa = new AnaSayfa();
		Class_Favoriler favori = new Class_Favoriler();
		openHepsiBurada("https://www.hepsiburada.com");
		SayfayiBuyut();
		anasayfa.check_HepsiBurada("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com");
		anasayfa.click_GirisYap();
		login.check_login();
		login.login_HepsiBurada("berkerkucukomuzlu@gmail.com", "123456*Beko");
		login.check_loginoldumu();
		anasayfa.set_AranacakUrun("iphone");
		anasayfa.click_UrunAra();
		anasayfa.check_AranilanUrunGeldimi("iphone");
		anasayfa.click_SayfaDeger("2");
		anasayfa.check_SayfaKontrol("iphone", "2");
		anasayfa.click_ListedeUruneTiklama(3);
		anasayfa.check_UrunAcildimi();
		anasayfa.click_FavorilereEkle();
		anasayfa.check_FavorilereEklendimi();
		anasayfa.click_XSayfaKapat();
		anasayfa.click_FavoriListem();
		favori.check_FavoriListesi();
		favori.sec_SonEklenenFavoriUrun();
		favori.click_SilveKontrolEt();// Fonksiyon Tam çalışmıyor Silme işleminden sonra açılan pop-ın butonlarını tanıtamadım.
		anasayfa.click_UyeCikisi();
	}
	
	
	
	
	
	
	
	
	
	
	
	public WebElement findByXPath(String xpath) {
	     return driver.findElement(By.xpath(xpath));
	 }
	 
	 public void waitForLoad(WebDriver driver) {
	     ExpectedCondition<Boolean> pageLoadCondition = new
	             ExpectedCondition<Boolean>() {
	                 public Boolean apply(WebDriver driver) {
	                     return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                 }
	             };
	     WebDriverWait wait = new WebDriverWait(driver, 30);
	     wait.until(pageLoadCondition);
	 }
	 
	 public boolean doesElementExist(String id) {
	     return driver.findElements(By.id(id)).size() != 0;
	 } 
	 
	 public boolean doesElementExistXpath(String xpath) {
	     return driver.findElements(By.xpath(xpath)).size() != 0;
	 } 
	 public void waitobjectXpath(String xpath) {
	 	wait = new WebDriverWait(driver, 20);
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	 }
	 public void waitobjectID(String id) {
	 	wait = new WebDriverWait(driver, 20);
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	 }
	 public static void openHepsiBurada(String url) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Senay\\Desktop\\geckodriver-v0.23.0-win64\\geckodriver.exe"); //cromedriver path uzantisi
		    driver= new FirefoxDriver();
		//	driver.quit();
			
			driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
			 wait = new WebDriverWait(driver, 10000);
			 driver.get(url);
		}
	 public static void SayfayiBuyut() {
			
			driver.manage().window().maximize();
		
		}
	 public void destroy(){
	    // driver.quit();
	 }
	 
	
	
	
	

}

