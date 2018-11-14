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



import java.security.spec.ECField;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.ListView;
public class Class_Login extends HepsiBurada_Senaryo{
	

	
	

	public void check_login() {
		boolean v_check1,v_check2,v_check3;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		v_check1=doesElementExist("email");
		System.out.println(v_check1);
		v_check2=doesElementExist("password");
		System.out.println(v_check2);
		v_check3=doesElementExistXpath("/html/body/div[2]/div[2]/div/section[1]/div/div[2]/form/div[4]/button");
		System.out.println(v_check3);
		if(v_check1 && v_check2 && v_check3 == true) {
			System.out.println("Login Ekranı Görüntülendi");
		}
	}
	
	public void set_Email(String email) {
		driver.findElement(By.id("email")).sendKeys(email);
		System.out.println("Email Alanına Girilen Değer :"+email);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void set_password(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		System.out.println("Email Alanına Girilen Değer :"+password);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void click_Giris() {
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/section[1]/div/div[2]/form/div[4]/button")).click();
		System.out.println("Giriş Butonuna Tıklandı");
		
	}
	
	public void login_HepsiBurada(String email,String password) {
		set_Email(email);
		set_password(password);
		click_Giris();
	}
	
	public void check_loginoldumu() {
		 waitobjectXpath("/html/body/div[3]/div[2]/div[2]/div[4]/div/div[2]/a[1]");
		
	/*	try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		String elemHtml = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[4]/div/div[2]/a[1]")).getAttribute("innerHTML");
		System.out.println(elemHtml);
		String kontrol="Hesabım";
		if(elemHtml.equals(kontrol)) {
			System.out.println("Sayfaya Login Olundu");
		}
		else 
		System.out.println();
	}
	
	

}
