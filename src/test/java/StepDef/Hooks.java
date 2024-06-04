package StepDef;

import Utils.MobileDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;


public class Hooks {


    @Before
    public void beforeMethod(){
        MobileDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @After
    public void afterMethod(){
        MobileDriver.closeDriver();
    }
}
