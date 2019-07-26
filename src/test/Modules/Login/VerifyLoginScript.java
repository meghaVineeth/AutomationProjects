import execution.HeaderData;

@HeaderData(
        testScriptDescription = "Verify UI elements and functionality of Blood banks listing screen.",
        testCaseId = "BB_046,BB_048,BB_056,BB_057",
        requirementID = "HH-5760",
        commandTimeout = "720",
        isResetRequired = false
)

public class VerifyLoginScript extends BaseScript {
    public static void verifyLoginScript() {
        findElementBy(landingScreenClass.GET_VACCINATED_MENU).click();
        findElementBy(landingScreenClass.GET_VACCINATED_BACK_BUTTON).click();
    }


}
