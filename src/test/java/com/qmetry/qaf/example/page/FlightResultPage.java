//package com.qmetry.qaf.example.page;
//
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import com.kayak.flight.reservation.util.Util;
//
//public class FlightResultPage {
//
//	WebDriver driver;
//	
//	By wait = By.xpath("//div[@class='Common-Results-ProgressBar theme-dark Hidden']");
//
//	By alert = By.xpath("//div[text()='Create a Price Alert, free.']");
//
//	By close = By.xpath("//div[text()='Create a Price Alert, free.']/../../../preceding-sibling::button");
//
//	By result = By.xpath("//span[contains(text(),'View Deal')]/parent::a");
//
//	public FlightResultPage(WebDriver driver) {
//		this.driver = driver;
//	}
//
//	public void clickOnResult(int n) throws Throwable {
//		Util.presenceOfElementLocated(driver,wait);
//		try {
//			if(driver.findElement(alert) != null) {
//				WebElement element = driver.findElement(close);
//				element.click();
//			}
//
//		} catch (Exception e) {
//		}
//
//		List<WebElement> list = driver.findElements(result);
//		int i = 0;
//		if (list.size() > 0) {
//			for (WebElement element : list) {
//				if (element.getText().trim().length() > 0 && ++i == n) {
//					element.click();
//					break;
//				}
//			}
//		}
//
//		Thread.sleep(1000);
//	}
//
//}