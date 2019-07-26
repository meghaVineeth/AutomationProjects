import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class ExecutionEngine {

    private AndroidDriver<MobileElement> androidDriver;
    private WebDriver webDriver;
    private IOSDriver iosDriver;

    public ExecutionEngine() throws Exception {
        this.androidDriver = setDriver();
    }

    public AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public IOSDriver getIosDriver() {
        return iosDriver;
    }

    private AndroidDriver<MobileElement> setDriver() throws Exception {
        InitialiseScript.setProjectProperties();
//        InitialiseScript.readConfigFile();
//        InitialiseScript.readArguments();
//        InitialiseScript.createTestNGXML();
        startAppiumServer();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobCapabilityType.PLATFORM_NAME.getValue(), ANDROID);
        capabilities.setCapability(MobCapabilityType.PLATFORM_VERSION.getValue(), "5.1.1");
        capabilities.setCapability(MobCapabilityType.DEVICE_NAME.getValue(), FrameworkConstants.deviceName);
        capabilities.setCapability(MobCapabilityType.APP_ACTIVITY.getValue(), FrameworkConstants.appActivity);
        capabilities.setCapability(MobCapabilityType.APP_PACKAGE.getValue(), FrameworkConstants.packageName);
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability(MobCapabilityType.NEW_COMMAND_TIMEOUT.getValue(), 60);

        FrameworkConstants.appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:" + FrameworkConstants.port + "/wd/hub"), capabilities);
        FrameworkConstants.driver = (AndroidDriver) FrameworkConstants.appiumDriver;
        FrameworkConstants.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Capability set for Android  " + FrameworkConstants.deviceName);

        return FrameworkConstants.driver;
    }


    public void startAppiumServer() throws Exception {
        writeInAppiumBatchFile(FrameworkConstants.port, FrameworkConstants.deviceID, FrameworkConstants.bootStrap, FrameworkConstants.chromeDriver);
        File shellScript = new File("appium.sh");
        /* if (isPortavailable(Integer.parseInt(port[i]))) {*/
        Runtime.getRuntime().exec("chmod u+x " + shellScript.getAbsolutePath());
        Runtime.getRuntime().exec("/usr/bin/open -n -F -a /Applications/Utilities/Terminal.app --args " +
                shellScript.getAbsolutePath());
        Thread.sleep(5000);
    }

    /**
     * Method Create and Write commands in bash or shell file
     * <p>
     * param port      : Port used in appium
     * param deviceID  : Device name
     * param bootStrap :
     */
    public void writeInAppiumBatchFile(String port, String deviceID, String bootStrap, String chromeDriver) {
        try {
            File file;

            file = new File("appium.sh");
            if (file.exists()) {
                if (!file.delete()) {
//                        FrameworkLogger.logFail("Appium.sh file not deleted");
                }
            }
            if (!file.createNewFile()) {
//                    FrameworkLogger.logFail("Appium.sh file not created");
            }

            port = "/usr/local/bin/node /usr/local/lib/node_modules/appium/build/lib/main.js" +
                    " --address 127.0.0.1 -U " + FrameworkConstants.deviceID + " --port " + FrameworkConstants.port + " --chromedriver-port "
                    + FrameworkConstants.chromeDriver + " --bootstrap-port " + FrameworkConstants.bootStrap;


            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(port);
            bw.flush();
            bw.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void tearDownDriver() throws Exception {
        androidDriver.quit();
        Utils.runProcessOnTerminal("killall node");
        Utils.runProcessOnTerminal("killall Terminal");
    }

    public void killAllApps() throws Exception {
    }
}
