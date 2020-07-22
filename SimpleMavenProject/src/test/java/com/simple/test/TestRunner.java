package com.simple.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/featurefiles", 
glue = { "com.simple.stepdef" },
tags = { "@dryrun" })
public class TestRunner {

}
