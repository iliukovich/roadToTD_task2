package tutby;

import org.testng.annotations.DataProvider;

public class DataDrivenLogIn {
    @DataProvider(name = "userData")
    public Object[][] provideUserData() {

        return new Object[][]{{"a1qatest@tut.by", "Qwerty123", "Tester Testov"}};

    }
}
