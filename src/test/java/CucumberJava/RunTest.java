package CucumberJava;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"CucumberJava"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"
            , "json:target/cucumber.json"
            , "junit:target/cucumber.xml"
//            , "rerun:target/rerun.txt"
            })

public class RunTest {}