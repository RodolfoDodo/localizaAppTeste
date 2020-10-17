package br.localiza.app.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver(){
		if(driver == null){
			createDriver();
		}
		return driver;
	}
	
	private static void createDriver(){
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("app", "C:\\Users\\Rodolfo\\workspace\\LocalizaAppTest\\Apk\\Menu-hmg-v2.1.6(216)-debug.apk");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appPackage", "com.localiza.menuapp");
		desiredCapabilities.setCapability("appActivity", "com.localiza.menuapp.ui.main.MainActivity");
		desiredCapabilities.setCapability("deviceName", "Nexus 6 API 29");
		desiredCapabilities.setCapability("platformVersion", "7");
		desiredCapabilities.setCapability("autoGrantPermissions", true);
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

		try {
			driver = new AndroidDriver <MobileElement> (new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		driver.findElementById("com.localiza.menuapp:id/botao_configuracoes").click();
		
	
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout").click();
		
		
		driver.findElementById("com.localiza.menuapp:id/input_senha").sendKeys("111");
		
		driver.findElementById("com.localiza.menuapp:id/btn_continuar").click();
		
		driver.findElementById("com.localiza.menuapp:id/layout_input_patrimonio").click();
		
		driver.findElementById("com.localiza.menuapp:id/input_patrimonio").sendKeys("teste");
		
		driver.findElementById("com.localiza.menuapp:id/layout_input_agencia").click();

		driver.findElementById("com.localiza.menuapp:id/input_agencia").sendKeys("aabhz");
	
		driver.findElementById("com.localiza.menuapp:id/layout_configuracoes").click();
		
		
		driver.findElementById("com.localiza.menuapp:id/botaoSalvar").click();
		
	}
	
	public static void killDriver(){
		if(driver != null){
			driver.quit();
			driver = null;
		}
	}
}
