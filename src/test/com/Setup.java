package com;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class Setup {

	WebDriver driver;
	WebElement element;
	Select select;
	ConnectBean con = new ConnectBean();

	@Given("^User open browser$")
	public void User_open_browser() {
		con.getSystem();
		driver = con.getDriver();
	}

	@When("^User click link addition calculator$")
	public void User_click_link_addition_calculator() {
		element = driver.findElement(By.xpath("/html/body/a[1]"));
		element.click();
	}

	@When("^User click link subtraction calculator$")
	public void User_click_link_subtraction_calculator() {
		element = driver.findElement(By.xpath("/html/body/a[2]"));
		element.click();
	}

	@When("^User click link multiplication calculator$")
	public void User_click_link_multiplication_calculator() {
		element = driver.findElement(By.xpath("/html/body/a[3]"));
		element.click();
	}

	@When("^User click link division calculator$")
	public void User_click_link_division_calculator() {
		element = driver.findElement(By.xpath("/html/body/a[4]"));
		element.click();
	}

	@Then("^User click addition (\\d+) calculator$")
	public void User_click_addition_calculator(int count) {
		element = driver.findElement(By.xpath("/html/body/div/input[2]"));
		element.clear();
		element.sendKeys(String.valueOf(count));

		Calculate calculator = new Calculate();
		String totalCal = Integer.toString(calculator.addition(count));

		element = driver.findElement(By.xpath("/html/body/div/input[3]"));
		String totalExpected = element.getAttribute("value").trim();
		Assert.assertEquals(totalExpected, totalCal);
	}

	@Then("^User click subtraction (\\d+) calculator$")
	public void User_click_subtraction_calculator(int count) {
		element = driver.findElement(By.xpath("/html/body/div/input[2]"));
		element.clear();
		element.sendKeys(String.valueOf(count));

		Calculate calculator = new Calculate();
		String totalCal = Integer.toString(calculator.subtraction(count));

		element = driver.findElement(By.xpath("/html/body/div/input[3]"));
		String totalExpected = element.getAttribute("value").trim();
		Assert.assertEquals(totalExpected, totalCal);
	}

	@Then("^User click multiplication (\\d+) calculator$")
	public void User_click_multiplication_calculator(int count) {
		element = driver.findElement(By.xpath("/html/body/div/input[2]"));
		element.clear();
		element.sendKeys(String.valueOf(count));

		Calculate calculator = new Calculate();
		String totalCal = Integer.toString(calculator.multiplication(count));

		element = driver.findElement(By.xpath("/html/body/div/input[3]"));
		String totalExpected = element.getAttribute("value").trim();
		Assert.assertEquals(totalExpected, totalCal);
	}

	@Then("^User click division (\\d+) calculator$")
	public void User_click_division_calculator(int count) {
		element = driver.findElement(By.xpath("/html/body/div/input[2]"));
		element.clear();
		element.sendKeys(String.valueOf(count));

		Calculate calculator = new Calculate();
		String totalCal = Integer.toString(calculator.division(count));

		element = driver.findElement(By.xpath("/html/body/div/input[3]"));
		String totalExpected = element.getAttribute("value").trim();
		Assert.assertEquals(totalExpected, totalCal);
	}

	@After
	public void tearDown() {
		try {
			Thread.sleep(1000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}