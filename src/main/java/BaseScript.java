import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseScript {
    protected static LoginScreenClass loginScreenClass = new LoginScreenClass();
    protected static LandingScreenClass landingScreenClass = new LandingScreenClass();

    protected static WebElement findElementBy(By by){
        WebElement wb = FrameworkConstants.getDriver().findElement(by);
        return wb;
    }

}
