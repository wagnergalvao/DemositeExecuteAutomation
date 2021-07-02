package br.com.prime.project.cucumberRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features", 
		glue = {
				"br.com.prime.project.steps", 
				"br.com.prime.project.support",
				"br.com.prime.project.pageObjects"				
		}, 
		plugin = {
				"pretty", 
				"json:target/cucumber.json", 
				"junit:target/cucumber.xml", 
				"de.monochromata.cucumber.report.PrettyReports:target/cucumber"
				}, 
		monochrome = true, 
		dryRun = false
		)
public class ProjectRunner {

}
