import com.google.common.base.Verify;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public static final int modulePriority = ModulePriority.basicPriority * ModulePriority.loginTest;

    public class LoginTestSanity {
        @Test(priority = modulePriority + 1, groups = "sanity")
        public void verifyLoginUI1() throws Exception {

            VerifyLoginScript.verifyLoginScript();
        }

        @Test(priority = modulePriority + 2, groups = "sanity")
        public void verifyLoginUI2() {
            System.out.println("This is LoginTest 2 in sanity pack");
        }
    }

    public class LoginTestTier1 {
        @Test(priority = modulePriority + 1, groups = "tier1")
        public void verifyLoginUI1() {
            System.out.println("This is LoginTest 1 in tier1 pack");
        }

        @Test(priority = modulePriority + 2, groups = "tier1")
        public void verifyLoginUI2() {
            System.out.println("This is LoginTest 2 in tier1 pack");
        }
    }

    @Test(priority = 3)
    public class LoginTestTier2 {
        @Test(priority = modulePriority + 1, groups = "tier2")
        public void verifyLoginUI1() {
            System.out.println("This is LoginTest 1 in tier2 pack");
        }

        @Test(priority = modulePriority + 2, groups = "tier2")
        public void verifyLoginUI2() {
            System.out.println("This is LoginTest 2 in tier2 pack");
        }
    }

}
