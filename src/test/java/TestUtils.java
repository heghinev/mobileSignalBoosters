import pageObjects.RegisterPage;

import java.util.UUID;

public class TestUtils {

    public static final String DEFAULT_PASSWORD = "123";

    public static void fillUserData(RegisterPage registerPage, String email) {
        registerPage.registerWith(email, DEFAULT_PASSWORD);
        registerPage.regWithAddressData("Test", "Test1", "111", "1111",
                "RA", "Baghramyan 1");
        registerPage.regWithShippingData("2222", "Yerevan", "Baghramyan2");
    }

    public static String randomEmail() {
        return UUID.randomUUID().toString() + "@test.com";
    }
}
