import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.HashMap;

public class FrameworkConstants {
    public static AppiumDriver<MobileElement> appiumDriver;
    public static AndroidDriver<MobileElement> driver;
    public static String appName = "RFH Immunisation App";
    public static String packageName = "";
    public static String deviceName = "Lenovo A6020a46";
    public static String deviceID = "d07ecc65";
    public static String chromeDriver = "4725";
    public static String port = "4723";
    public static String bootStrap = "4724";
    public static String appActivity = "";
    public static String version;
    public static String platform;
    public static String testSuitePath;
    public static String logsPath = "/Users/megha.km/Documents/AutomationWorkspace/TestNG/Result/Logs";
    public static String rerunPath = "/Users/megha.km/Documents/AutomationWorkspace/TestNG/Result/Logs";
    public static String reportsPath = "/Users/megha.km/Documents/AutomationWorkspace/TestNG/Result/Logs";

    public static final boolean isResetRequired = false;
    public static final String testScriptDescription = null;
    public static final String testCaseId = null;
    public static final String requirementId = null;


    public static HashMap<String, HashMap<String, String>> environmentVariables;

    public static AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    public static AndroidDriver<MobileElement> getDriver() {
        return driver;
    }
}
