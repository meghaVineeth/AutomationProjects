import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BaseTest extends BaseScript {

    public static AndroidDriver<MobileElement> driver;
    private ExecutionEngine executionEngine;

    @BeforeSuite
    protected void startAppium() throws Exception {
        System.out.println("Before Suite");
        executionEngine = new ExecutionEngine();
        this.driver = executionEngine.getAndroidDriver();
    }

    @AfterClass
    protected void afterClassActions() {
        System.out.println("After class");
    }


    @BeforeClass
    protected void beforeClassActions() {
        System.out.println("Before class");
    }

    @AfterTest
    protected void afterTestActions() {
        System.out.println("After Test");
    }


    @BeforeTest
    protected void beforeTestActions() {
        System.out.println("Before Test");
    }


    @AfterMethod
    protected void afterMethodActions() throws Exception{
        System.out.println("After Method");
    }


    @BeforeMethod
    protected void beforeMethodActions() {
        System.out.println("Before Method");
    }

    /**
     * The method will be called inside test method if test data are absent
     *
     * @throws Exception - throws {@link NotImplementedException} if method was not overridden
     */
    @Test
    protected void invokeTest() throws Exception {
        try {

        } catch (Exception e) {

        }
    }

    @AfterSuite
    protected void killServer() throws Exception {
        System.out.println("After Suite");
        executionEngine.tearDownDriver();
    }

    public static AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

}
