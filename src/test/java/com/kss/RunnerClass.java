package com.kss;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber-reports/Cucumber.json"},
        features = {
        "src/test/java/com/kss"
        },
        glue = "step_definitions")

public class RunnerClass {
    public RunnerClass(){

    }
}
