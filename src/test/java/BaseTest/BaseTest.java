package BaseTest;

import org.testng.annotations.*;

import java.util.Random;

public class BaseTest {
    @BeforeSuite()
    public void suiteSetup(){
        System.out.println("in before suite");
    }
    @BeforeClass()
    public void setup(){
        System.out.println("in before class");
    }

    @AfterClass()
    public void cleanup(){
        System.out.println("in after class");
    }
    @AfterSuite()
    public void suiteCleanup(){
        System.out.println("in after suite");
    }

    public int random3DigitGenerator(){
        Random random = new Random();
        return random.nextInt(900) + 100;
    }
}
