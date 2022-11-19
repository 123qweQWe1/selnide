package selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import static com.codeborne.selenide.Selenide.*;


public class HomeTest extends BaseClass {
    @Test
    public void task1() {
        Assert.assertEquals(WebDriverRunner.url(), "https://demoqa.com/books");
        Assert.assertEquals(title(), "ToolsQA");

        List<SelenideElement> images = $$(By.xpath("//div[@role='rowgroup']//img"));
        for (SelenideElement image : images) {
            System.out.print(image.attr("src") + ", ");
            Assert.assertFalse(Objects.requireNonNull(image.attr("src")).isEmpty());
        }

        List<String> titles = $$(By.xpath("//div[@role='rowgroup']/div/div[2]")).texts();
        System.out.println(titles);
        for (String title : titles) {
            Assert.assertFalse(title.isEmpty());
        }

        List<String> authors = $$(By.xpath("//div[@role='rowgroup']/div/div[3]")).texts();
        System.out.println(authors);
        for (String author : authors) {
            Assert.assertFalse(author.isEmpty());
        }
        List<String> publishers = $$(By.xpath("//div[@role='rowgroup']/div/div[4]")).texts();
        System.out.println(publishers);
        for (String publisher : publishers) {
            Assert.assertFalse(publisher.isEmpty());
        }
    }

    @Test
    public void task2() {
        List<String> publishers = $$(By.xpath("//div[@role='rowgroup']/div/div[4]")).texts();
        System.out.println("Publishers: " + publishers);
        //List<String> titles = $$(By.xpath("//div[@role='rowgroup']//a")).texts();
        List<SelenideElement> titles = $$(By.xpath("//div[@role='rowgroup']//a"));
        System.out.println("Titles: " + titles);
        List<SelenideElement> titlesWithJavaScript = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            if (publishers.get(i).equals("O'Reilly Media") && titles.get(i).text().contains("JavaScript")) {
                titlesWithJavaScript.add(titles.get(i));
                System.out.println("Books: " + titles.get(i).text());
            }
        }
        System.out.println(titlesWithJavaScript);
        System.out.println("Books count contains JavaScript: " + titlesWithJavaScript.size());
        Assert.assertEquals(titlesWithJavaScript.size(), 10);
        Assert.assertEquals(titlesWithJavaScript.get(0).text(), "Learning JavaScript Design Patterns");
        SelenideElement elemnt  =  titlesWithJavaScript.get(0);
        elemnt.click();

    }
}
