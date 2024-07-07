package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

import java.time.Duration;

public class TestBase {

    /**
     * This class contains common configuration methods for all other test classes in this framework
     * All test classes should extend this class to obtain common configurations
     */

    @BeforeMethod (alwaysRun = true)
    public void setUp(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
//        Driver.quitDriver();
    }

}
