import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class InitialiseScript extends ExecutionEngine {

    protected static AndroidDriver<MobileElement> driver;

    public InitialiseScript() throws Exception {
        this.driver = getAndroidDriver();
    }

    protected static void readHeaderData() {

    }


    protected static void setProjectProperties() throws Exception{
        FrameworkConstants.packageName = Utils.readProperties("project.properties", "applicationpackage");
        FrameworkConstants.appActivity = Utils.readProperties("project.properties","applicationactivity");
        FrameworkConstants.appName = Utils.readProperties("project.properties","applicationname");
//        FrameworkConstants.testSuitePath = Utils.readProperties("project.properties","testsuitepath");
    }

    public static void readConfigFile() {
    }

    public void createTestNGXML() {

    }

}
