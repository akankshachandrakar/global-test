package com.workset.music;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTrack extends BaseTest {

	@Test
	public void checkRecentTrack(){
	driver.get("http://www.capitalfm.com/london/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
	driver.manage().window().maximize();
	Assert.assertTrue(recentPlay(), "Justin Biber track Not played recently");
	
	
	}	
	@Test
	public void checNowTrack(){
	driver.get("http://www.capitalfm.com/london/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
	driver.manage().window().maximize();
	Assert.assertTrue(nowPlaying(), "Justin Biber track Not playing now");
			
	}	
}
