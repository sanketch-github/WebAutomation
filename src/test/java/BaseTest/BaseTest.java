package BaseTest;

import org.testng.annotations.*;

public class BaseTest {
    @BeforeSuite()
    public void suiteSetup(){
        //add log4j
    }
    @BeforeClass()
    public void setup(){
        //add log4j
    }

    @AfterClass()
    public void cleanup(){
        //add log4j
    }
    @AfterSuite()
    public void suiteCleanup(){
        //add log4j
    }
}
