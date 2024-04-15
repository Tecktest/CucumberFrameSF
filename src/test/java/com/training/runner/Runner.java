package com.training.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="C:\\Users\\pradh\\TekarchJanesh\\CucumberFrameworkSalesForce\\features\\LoginSalesForce.feature",
				glue={"com.training.steps"},
				plugin= {"pretty", "html:target/cucumber-reports/cucumber.html"
				})

public class Runner extends AbstractTestNGCucumberTests{

}
