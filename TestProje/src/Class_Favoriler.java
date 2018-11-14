import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
public class Class_Favoriler extends HepsiBurada_Senaryo {

	public void check_FavoriListesi() {
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(driver.findElement(By.cssSelector(".myPagesH2")).getText(), "Favori Listeniz");
		System.out.println("Favori Listesi Sayfası Görüntülendi");
		
	}
	public void sec_SonEklenenFavoriUrun() {
		driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_rptShoppingList_ctl01_chkSelect")).click();
		System.out.println("Son eklenen Ürün Seçildi");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void click_SilveKontrolEt() {
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnDelete")).click();
		java.util.List<WebElement> List = driver.findElements(By.tagName("input"));
		int deger=List.size();
		System.out.println("Silme Butonuna Tıklandı");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

Actions action = new Actions(driver);
 
action.sendKeys(Keys.ENTER);
action.sendKeys(Keys.ENTER);
action.sendKeys(Keys.ENTER);

java.util.List<WebElement> List1 = driver.findElements(By.tagName("input"));
int deger1 = List1.size();
if(deger==(deger1+1)) {
	System.out.println("Silme İşlemi gerçekleştirilmiştir.");
}
	}
	
}
