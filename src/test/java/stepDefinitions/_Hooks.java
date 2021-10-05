package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Driver;
import utilities.ExcelUtility;
import utilities.ParentClass;

public class _Hooks {
    @Before
    public void before(Scenario scenario) {
        System.out.println(scenario.getName() + " has been started");
    }

    @After
    public void after(Scenario scenario) {
        System.out.println(scenario.getName() + " : " + scenario.getStatus());

        if (scenario.getStatus().toString() == "FAILED") {
            ParentClass.screenShot(scenario);
        }

        ExcelUtility.writeScenarioToExcel(scenario);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Driver.quitDriver();
    }
}
