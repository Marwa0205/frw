package com.todo.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class Setup extends BasePage {

	public Setup() throws IOException {
		super();
	}

@Parameters({"browser"})
	@BeforeMethod
	public void setupTest(String browser) {
		initialization(browser);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

	}

	@AfterMethod

	public void cleanTest() {
		driver.navigate().refresh();
		driver.quit();
	}
}
