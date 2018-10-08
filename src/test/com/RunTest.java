package com;

import org.junit.runner.RunWith;
import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "feature/Calculate.feature")

public class RunTest {
	public static void main(String[] args) {
		System.out.println("Cucumber framework in Selenium + Java 8 Lambda");
	}
}
