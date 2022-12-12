package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.components.RegistrationFormPage;


public class TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @BeforeAll
    static void SetUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

        System.out.println("### BeforeAll");
    }
    @BeforeEach
    void openPage() {
        Selenide.open("/automation-practice-form");
        System.out.println("BeforeEach");
    }
}
