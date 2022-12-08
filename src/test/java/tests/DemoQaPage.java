package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoQaPage {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
    void openPage() {
        open("/text-box");
        System.out.println("BeforeEach");
    }
    @AfterEach
    void closePage()
    {Selenide.sleep(5000);
        Selenide.closeWebDriver();
        System.out.println("AfterEach");

    }
    @AfterAll
    static void cleanDB() {
        System.out.println("AfterAll");
    }

    @Test
    void fillFormTest() {
        String name = "Ragnar Lothbrok";
        String eMail = "somemail@yandex.ru";
        String curAddress = "Valhalla";
        String perAddress = "Kattegat";
        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue(eMail);
        $("[id=currentAddress]").setValue(curAddress);
        $("[id=permanentAddress]").setValue(perAddress);
        $("[id=submit]").click();

        //Asserts

        $("[id=output]").shouldHave(Condition.text(name),
                Condition.text(eMail),
                Condition.text(curAddress),
                Condition.text(perAddress));
        $("[id=output] [id=email]").shouldHave(Condition.text(eMail));
        $("[id=output] [id=name]").shouldHave(Condition.text(name));
        $("p[id=currentAddress]").shouldHave(Condition.text(curAddress));
        $("p[id=permanentAddress]").shouldHave(Condition.text(perAddress));

//        Same as (old):
//        String expectedPermanentAddress = "Kattegat";
//        String actualPermanentAddress = $("p[id=permanentAddress]").text();
//        assertEquals(expectedPermanentAddress,actualPermanentAddress);


    }
}