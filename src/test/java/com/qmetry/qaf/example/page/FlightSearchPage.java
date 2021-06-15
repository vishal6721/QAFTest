//package com.qmetry.qaf.example.page;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class FlightSearchPage {
//	private static SimpleDateFormat oldformat = new SimpleDateFormat("MM/dd/yyyy");;
//	private static SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
//	WebDriver driver;
//
//	By originCity = By.xpath("//div[text()='From?']");
//
//	By removeOrgValue = By.xpath("//div[@aria-label='Flight origin input']//div[@aria-label='Remove']");
//
//	By Origintext = By.xpath("//input[@placeholder='From?']");
//
//	By near = By.xpath("//li[@aria-label='@@']");
//
//	By destCity = By.xpath("//div[text()='To?']");
//
//	By Desttext = By.xpath("//input[@placeholder='To?']");
//
//	By removeDestValue = By.xpath("//div[@aria-label='Flight destination input']//div[@aria-label='Remove']");
//
//	By findDate = By.xpath("//div[@aria-label='Departure and return dates input']//span[@class='cQtq-value']");
//
//	By openDate = By.xpath("//div[@aria-label='Departure and return dates input']//span[@role='button']");
//
//	By preMonth = By.xpath("//div[@aria-label='Previous month']");
//
//	By nextMonth = By.xpath("//div[@aria-label='Next Month']");
//
//	By search = By.xpath("//button[@aria-label='Search']");
//
//	By alert = By.xpath("//div[contains(text(),\"Please enter unique 'From' and 'To' airports.\")]");
//
//	By dismiss = By.xpath("//div[contains(text(),\"Please enter unique 'From' and 'To' airports.\")]/../..//button");
//
//	public void setDate(String date) {
//
//		try {
//			date = formatter.format(oldformat.parse(date));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		driver.findElement(By.xpath("//div[@aria-label='" + date + "']")).click();
//	}
//
//	public FlightSearchPage(WebDriver driver) {
//		this.driver = driver;
//	}
//
//	public void setOrigin(String origin, String nearbyCity) throws Throwable {
//		setCity("origin", removeOrgValue, originCity, origin, nearbyCity);
//	}
//
//	public void setDest(String dest, String nearByDest) throws Throwable {
//		setCity("dest", removeDestValue, destCity, dest, nearByDest);
//	}
//
//	public void setDate(String ddate, String rdate) throws Throwable {
//		List<WebElement> list = driver.findElements(findDate);
//		String[] arr1 = list.get(0).getText().trim().split(" ");
//		String[] arr2 = arr1[1].split("/");
//		int currntMonth = Integer.parseInt(arr2[0]);
//		int targetMonth = Integer.parseInt((ddate.split("/"))[0]);
//
//		driver.findElement(openDate).click();
//		moveToDate(targetMonth, currntMonth);
//		currntMonth = targetMonth;
//		Thread.sleep(500);
//		setDate(ddate);
//
//		targetMonth = Integer.parseInt((rdate.split("/"))[0]);
//		moveToDate(targetMonth, currntMonth);
//		setDate(rdate);
//	}
//
//	public String submiteSearch() throws Throwable {
//		String message = "";
//
//		driver.findElement(search).click();
//
//		try {
//			if (driver.findElement(alert) != null) {
//				WebElement element = driver.findElement(dismiss);
//				element.click();
//				message = "Please enter unique 'From' and 'To' airports.";
//			}
//		} catch (Exception e) {
//		}
//
//		return message;
//	}
//
//	private void setCity(String dir, By removeValue, By findCity, String cityValue, String nearByCity) {
//		boolean flag = false;
//
//		try {
//
//			WebElement removeElement = driver.findElement(removeValue);
//			if (removeElement != null) {
//				removeElement.click();
//				flag = true;
//			}
//		} catch (Exception e) {
//		}
//		if (!flag) {
//			driver.findElement(findCity).click();
//		}
//		if (dir.equals("origin")) {
//			WebElement orgelement = driver.findElement(Origintext);
//			orgelement.sendKeys(cityValue);
//		} else {
//			WebElement orgelement = driver.findElement(Desttext);
//			orgelement.sendKeys(cityValue);
//
//		}
//
//		if (nearByCity.isEmpty()) {
//			Util.elementToBeClickable(driver, By.xpath("//li[contains(@aria-label,'" + cityValue + "')]")).click();
//		} else {
//			Util.elementToBeClickable(driver, By.xpath("//span[contains(text(),'" + nearByCity + "')]")).click();
//		}
//
//	}
//
//	public void moveToDate(int targetMonth, int currntMonth) throws Throwable {
//
//		while (!(targetMonth - currntMonth == 0)) {
//			if (targetMonth - currntMonth > 0) {
//				driver.findElement(nextMonth).click();
//				currntMonth++;
//			} else if (targetMonth - currntMonth < 0) {
//				driver.findElement(preMonth).click();
//				currntMonth--;
//			}
//			Thread.sleep(500);
//		}
//	}
//
//}
