import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.awt.List;
import java.lang.reflect.Array;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.ListView;

public class AnaSayfa extends HepsiBurada_Senaryo {

public void check_HepsiBurada(String title) {
		
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void click_GirisYap() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions builder = new Actions(driver); 
		WebElement Element1 = driver.findElement(By.xpath("//*[@id=\"myAccount\"]"));
		builder.moveToElement(Element1, 1, 1).click().build().perform();	
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/div/div[2]/a[2]")).getLocation();
		System.out.println("Giriş Yap Tıklandı");
		//waitobjectXpath("//*[@id=\\\\\\\"login\\\\");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement Element = driver.findElement(By.xpath("//*[@id=\"login\"]")); 
		builder.moveToElement(Element, 1, 1).click().build().perform();	
	}
	
	public void set_AranacakUrun(String urun) {
		driver.findElement(By.id("productSearch")).sendKeys(urun);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Arama İçin Girilen Değer : "+urun);
	}
	
	public void click_UrunAra() {
		driver.findElement(By.id("buttonProductSearch")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ara Butonuna Tıklandı");
	}

	public void check_AranilanUrunGeldimi(String urun) {
		String array1[];
		String array2[];
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
	//	String deger = "\""+urun+"\"";
	//	System.out.println(deger);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/main/div[2]/div/div/div[1]/div/div[2]/section/div[1]/header/h1")));
		//System.out.println("untili geçti");
		String aranilandeger = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div/div[1]/div/div[2]/section/div[1]/header/h1")).getAttribute("innerHTML");
		array1=aranilandeger.split("“");
		//System.out.println(array1[1]);
		 array2=array1[1].split("”");
	//	 System.out.println(array2[0]);
		//System.out.println(aranilandeger);
		if(array2[0].equals(urun)) {
			System.out.println("Aranılan Değer İçin Sonuçlar Listelendi");
		}
		else
		{
			System.out.println("Aranılan Değer Kontrolü Başarısız");
		}
		
	}
	public void click_SayfaDeger(String deger) {
		driver.findElement(By.className("page-"+deger)).click();
		System.out.println(deger+". Sayfaya Tıklandı");
	}
	
	public void check_SayfaKontrol(String arama,String sayfa) {
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		String currenturl,url;
		currenturl=driver.getCurrentUrl();
		url = "https://www.hepsiburada.com/ara?q="+arama+"&sayfa="+sayfa+"";
		
		if(currenturl.equals(url)) {
			System.out.println(arama+" araması için "+sayfa+". Sayfadadır");
		}
		else
		{
			System.out.println("Sayfa Kontrolü Sağlanamadı");
		}
		
		
	}
	
	public void click_ListedeUruneTiklama(int a) {
		
	 driver.findElement(By.cssSelector("li.search-item:nth-child("+a+") > div:nth-child(1)")).click();
		
		System.out.println("Listeki"+a+". ürüne tıklandı");
		
	}
	
	public void check_UrunAcildimi() {
		boolean v_check1;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#productDetailsCarousel > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")));
		v_check1= doesElementExistXpath("/html/body/div[4]/main/div[4]/section[1]/div[4]/div/div[1]/div[1]/div[1]/div[1]/div/div[1]");
		if(v_check1==true) {
			System.out.println("Seçilen Ürün Detayı Görüntülendi");
		}
		
	}
	
	public void click_FavorilereEkle() {
		driver.findElement(By.cssSelector(".favorite")).click();
		System.out.println("Favorilere Eklendi");
	}
	public void check_FavorilereEklendimi() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#notification > div:nth-child(1) > i:nth-child(1)")));
		if(doesElementExistXpath("/html/body/div[9]/div/span")) {
			System.out.println("Favorilere Eklendi Uyarısı Görüntülendi");
		}
	}
	
	public void click_XSayfaKapat() {
		driver.findElement(By.cssSelector("#notification > div:nth-child(1) > i:nth-child(1)")).click();
		System.out.println("X ' basıldı");
	}
	
	public void click_FavoriListem() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions builder = new Actions(driver); 
		WebElement Element1 = driver.findElement(By.xpath("//*[@id=\"myAccount\"]"));
		builder.moveToElement(Element1, 1, 1).click().build().perform();	
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/div/div[2]/a[2]")).getLocation();
		System.out.println("Giriş Yap Tıklandı");
		//waitobjectXpath("//*[@id=\\\\\\\"login\\\\");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement Element = driver.findElement(By.cssSelector("li.with-border:nth-child(3) > a:nth-child(1)")); 
		builder.moveToElement(Element, 1, 1).click().build().perform();	
	}
	
	
public void click_UyeCikisi() {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		Actions builder = new Actions(driver); 
		WebElement Element1 = driver.findElement(By.xpath("//*[@id=\"myAccount\"]"));
		builder.moveToElement(Element1, 1, 1).click().build().perform();	
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/div/div[2]/a[2]")).getLocation();
		System.out.println("Giriş Yap Tıklandı");
		//waitobjectXpath("//*[@id=\\\\\\\"login\\\\");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement Element = driver.findElement(By.cssSelector("li.with-border:nth-child(6) > a:nth-child(1)")); 
		builder.moveToElement(Element, 1, 1).click().build().perform();	
	}
	
	
}
