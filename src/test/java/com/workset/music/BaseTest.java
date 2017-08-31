package com.workset.music;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	protected WebDriver driver;
	@BeforeMethod 
	public void init()
	{
		System.setProperty("webdriver.chrome.driver",
				"driver/chrome/chromedriver.exe");
		driver = new ChromeDriver();	
		
	}

	public boolean recentPlay() {
		boolean isPresent = false;
		List<WebElement> list = driver.findElements(By.xpath(
				"//div[contains(@class, 'now_playing_card')]//article[contains(@class, 'recently_played_track')]//div[contains(@class, 'artist')]"));
		for (WebElement i : list) {
			if (i.getText().equalsIgnoreCase("Justin Bieber")) {
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}
	public boolean nowPlaying() {
		boolean isPresent = false;
		WebElement t = driver.findElement(By.xpath(
				"//div[contains(@class, 'now_playing_card')]//article[contains(@class, 'card_top_track')]//div[contains(@class, 'track__track-info')]//div[contains(@class, 'artist')]"));
		if (t.getText().equalsIgnoreCase("Justin Bieber")) {
			isPresent = true;
		}
		return isPresent;
	}
	@AfterMethod
	public void stop() {
		
		if (null != driver) {
			driver.quit();
		}
	}
}
