package com.training.steps;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {	

	WebDriver driver;

	@Before
	public void setup() {
		if (driver==null) {
		driver = new ChromeDriver();
		}
	}
	@After
	public void tearDown() {
		driver.close();
		driver=null;
	}	

	@Given("browser is open")
	public void browser_is_open() {
		driver.manage().window().maximize();	   
	}
	
	@And("user is on login page")
	public void user_is_on_login_page() {
		String url = "https://login.salesforce.com/";
		driver.get(url);	
	}
	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys(username);
		System.out.println("username entered");  
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(password);
		System.out.println("Password entered");
	}

	@And("user clicks on login")
	public void user_clicks_on_login() {
		driver.findElement(By.id("Login")).click();
		System.out.println("Login button clicked");

	}
	@Then("user is navigated to homepage")
	public void user_is_navigated_to_homepage() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		
		String expectTitle = "Lightning Experience";
		String actualTitle = driver.getTitle();
		//Assert.assertEquals(expectTitle, actualTitle);
		Thread.sleep(2000);
	}

}

