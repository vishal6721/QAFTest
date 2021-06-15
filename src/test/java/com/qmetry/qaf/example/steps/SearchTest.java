//package com.qmetry.qaf.example.steps;
//
//import org.openqa.selenium.WebDriver;
//
//
//import com.qmetry.qaf.automation.step.QAFTestStep;
//
//
//public class SearchTest {
//
//	protected static WebDriver driver = null;
//
//	private static int i = 1;
//
//	@Before
//	public void init() {
//		driver = Util.getChromeDriver();
//		driver.get("https://www.kayak.com");
//		Report.startTest("Test" + 1);
//	}
//
//	private HomePage homePage;
//	private FlightSearchPage searchPage;
//	private FlightResultPage resultPage;
//
//	@QAFTestStep(description ="User navigate to Kayak flight page")
//	public void user_navigate_to_Kayak_flight_page() throws Throwable {
//		homePage = new HomePage(driver);
//		homePage.clickFlightLink();
//		Report.logInfo(Status.INFO, "User navigate to Kayak flight page");
//	}
//
//	@QAFTestStep(description ="User enters origin {0} and nearby {1} city")
//	public void user_enters_origin_and_nearby_city(String origin, String city) throws Throwable {
//		searchPage = new FlightSearchPage(driver);
//		searchPage.setOrigin(origin, city);
//		Report.logInfo(Status.INFO, "User enters origin city -" + origin);
//		if (!city.isBlank()) {
//			Report.logInfo(Status.INFO, "User enters nearby city -" + city);
//		}
//	}
//
//	@QAFTestStep(description ="User enters destination {0} and nearby {1} city")
//	public void user_enters_destination_and_nearby_city(String dest, String city) throws Throwable {
//		searchPage.setDest(dest, city);
//		Report.logInfo(Status.INFO, "User enters destination city -" + dest);
//		if (!city.isBlank()) {
//			Report.logInfo(Status.INFO, "User enters nearby city -" + city);
//		}
//	}
//
//	@QAFTestStep(description ="User departure {0} date and return {1} date")
//	public void user_departure_date_and_return_date(String departDate, String returnDate) throws Throwable {
//		searchPage.setDate(departDate, returnDate);
//		Report.logInfo(Status.INFO, "User enters departure date -" + departDate);
//		Report.logInfo(Status.INFO, "User enters return date -" + returnDate);
//	}
//
//	@QAFTestStep(description ="User click search button")
//	public void user_click_search_button() throws Throwable {
//		String msg = "Please enter unique 'From' and 'To' airports.";
//		Report.logInfo(Status.INFO, "Searching ");
//		String message = searchPage.submiteSearch();
//		if (message.equals(msg)) {
//			Report.logInfo(Status.FAIL, msg);
//			Assert.assertTrue(message.contains(msg));
//		}
//	}
//
//	@QAFTestStep(description ="User click on nth {0} result on results page")
//	public void user_click_on_nth_result_on_results_page(Integer count) throws Throwable {
//		resultPage = new FlightResultPage(driver);
//		resultPage.clickOnResult(count);
//		Report.logInfo(Status.PASS, count + "th Search results open for booking");
//	}
//
//	@After
//	public void clean() {
//		i++;
//		Report.closeTest();
//		driver.close();
//	}
//}