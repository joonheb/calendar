package Semi2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Crawling {
	public final static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public final static String WEB_DRIVER_PATH = "C:\\Users\\CJB\\eclipse-workspace\\Semi\\libs\\Selenium\\chromedriver.exe";
	
	private String url;
	private WebDriver driver;
	int count;
	
	public Crawling(int count) {
		this.count =count;
		SeoulDAO dao = new SeoulDAO();
		dao.selectTourCode(count);
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		url = dao.getStr();
		//url = "https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=63%EB%B9%8C%EB%94%A9";
		crawl();
	}

	public Crawling(int count, boolean noUse) {
		this.count =count;
		SeoulDAO dao = new SeoulDAO();
		dao.selectFoodCode(count);
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		url = dao.getStr();
		crawl();
	}
	
	private void crawl() {
		try {
			driver.get(url);
			
		}catch(Exception e) {
			driver.close();
		}
	}
}
