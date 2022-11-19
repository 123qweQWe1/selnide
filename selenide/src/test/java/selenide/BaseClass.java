package selenide;

import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BaseClass {
    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("https://demoqa.com/books");
    }
}
