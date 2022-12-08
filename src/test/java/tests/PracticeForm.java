package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PracticeForm {

    @BeforeAll
    static void SetUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1225x990";

        System.out.println("### BeforeAll");
    }

    @BeforeEach
    void openPage() {
        Selenide.open("/automation-practice-form");
        System.out.println("BeforeEach");
    }

    @AfterEach
    void closePage(){
        Selenide.sleep(5000);
        Selenide.closeWebDriver();
        System.out.println("AfterEach");
    }

    @AfterAll
    static void cleanDB() {
        System.out.println("AfterAll");

    }

    @Test
    void fillFormTest() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('fixedban').remove()");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        String firstName = "Arven";
        String lastName = "Nevra";
        String eMail = "arven@nina.win";
        Integer number = 1234567890;
        String address = "Tawarwaith";
        String subject = "History";
        $("[id=firstName").setValue(firstName);
        $("[id=lastName").setValue(lastName);
        $("[id=userEmail").setValue(eMail);
        $("#genterWrapper").$(byText("Female")).click();
        $("[id=userNumber]").setValue(Integer.toString(number));
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue(("1901"));
        $(".react-datepicker__day--012").click();
        $("#subjectsInput").sendKeys(subject);
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("04988436.webp");
        $("#currentAddress").setValue(address);
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        //Submit is not clickable, taken by cords with random arguments 0 and 0
        cantClick(0,0);

        //Asserts
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        checkTable("Date of Birth", "12 January,1901");
        $("#closeLargeModal").click();
        $("[id=firstName").shouldBe(visible);

    }
        //Methods
    private void cantClick(int h, int w) {
        SelenideElement submitButton = $("#submit");
        h = submitButton.getRect().height;
        w = submitButton.getRect().width;
        h = h-30;
        w = w-70;
        Actions builder = new Actions(getWebDriver());
        builder.moveToElement(submitButton,-w,-h).click().build().perform();
    }
    private void checkTable(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

    }
}
