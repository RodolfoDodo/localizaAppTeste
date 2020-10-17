package br.localiza.app;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.localiza.app.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Login {

	
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void iniciarAppium()throws MalformedURLException{
		driver = DriverFactory.getDriver();
	}
	
	@After
	public void tearDown(){
		DriverFactory.killDriver();
	}
	
	@Test
	public void loginSucesso() throws MalformedURLException{
		driver.findElementById("com.localiza.menuapp:id/input_matricula").sendKeys("110508");
		
		driver.findElementById("com.localiza.menuapp:id/input_senha").sendKeys("3487");
		
		driver.findElementById("com.localiza.menuapp:id/botao_login").click();
		
		driver.findElementById("com.localiza.menuapp:id/botaoPositivo").click();
		
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[2]").click();
		
		
		driver.findElementById("com.localiza.combustivelapp:id/edtPlaca").click();
		driver.findElementById("com.localiza.combustivelapp:id/edtPlaca").sendKeys("QQI9763");
		
		driver.findElementById("com.localiza.combustivelapp:id/btnBuscar").click();
		
		driver.findElementById("com.localiza.combustivelapp:id/layoutFornecedor").click();
		
		String nomePlaca = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
		Assert.assertEquals("QQI9763", nomePlaca);
		
		driver.findElementById("com.localiza.combustivelapp:id/edtCodigoMatricula").clear();
		
		driver.findElementById("com.localiza.combustivelapp:id/edtCodigoMatricula").sendKeys("110508");
		
		driver.findElementByXPath("(//android.widget.ImageButton[@content-desc='Show dropdown menu'])[1]").click();
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[2]").click();
		
		driver.findElementById("com.localiza.combustivelapp:id/btnAbastecer").click();
		
		driver.findElementById("com.localiza.combustivelapp:id/botaoPositivo").click();
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button").click();
		
		//litros
		driver.findElementById("com.localiza.combustivelapp:id/edtLitros").sendKeys("40");
		
		driver.findElementById("com.localiza.combustivelapp:id/edtValor").sendKeys("50");
		
		driver.findElementById("com.localiza.combustivelapp:id/btnConfirmarAbastecimento").click();
		
		driver.findElementById("com.localiza.combustivelapp:id/botao_positivo").click();
		
		driver.findElementById("com.localiza.combustivelapp:id/botaoPositivo").click();
		
		
		//voltei para agencia
		
		driver.findElementById("com.localiza.combustivelapp:id/btnEncerrar").click();
		
		driver.findElementById("com.localiza.combustivelapp:id/botaoPositivo").click();
		
		
		//atenção
		
		driver.findElementById("com.localiza.combustivelapp:id/botaoPositivo").click();
		
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button").click();
	}
}
