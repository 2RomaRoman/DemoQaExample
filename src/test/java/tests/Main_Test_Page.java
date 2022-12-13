package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class Main_Test_Page extends TestBase {


    @BeforeEach
    void openPage() {
        Selenide.open("/automation-practice-form");
        System.out.println("BeforeEach");
    }

    @AfterEach
    void closePage(){
        Selenide.sleep(1000);
        Selenide.closeWebDriver();
        System.out.println("AfterEach");
    }

    @AfterAll
    static void cleanDB() {
        System.out.println("AfterAll");

    }


    @Test
    void fillFormPositive() {
//Test data
        String firstName = "Arven",lastName = "Nerva"
                ,Email = "arven@nina.win",gender = "Female"
                ,subject = "History",address = "Tawarwaith"
                ,state = "NCR",city = "Delhi"
                ,dd = "12",mm = "January",yy = "1901"
                ,element = "#submit",notClickableFromTop = "top"
                ,hobbie1 = "Sports",hobbie2 = "Reading",hobbie3 = "Music"
                ,targetToScroll1 = "#state", targetToScroll2 = "#city",
                uploadedFile = "04988436.webp";
//Fill up form
        Integer number = 1234567890;
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(Email)
                .setGender(gender)
                .setNumber(number)
                .setDateOfBirth(dd, mm, yy)
                .setSubject(subject)
                .setHobbies(hobbie1).setHobbies(hobbie2).setHobbies(hobbie3)
                .upload(uploadedFile)
                .setAddress(address)
                .scrollToAndClick(targetToScroll1)
                .setState(state)
                .scrollToAndClick(targetToScroll2)
                .setCity(city)
                .cantClickElement(element,notClickableFromTop);
//Asserts
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationFormPage.checkResult("Student Name", firstName + " " + lastName)
                            .checkResult("Student Email", Email)
                            .checkResult("Gender", gender)
                            .checkResult("Mobile", Integer.toString(number))
                            .checkResult("Date of Birth", dd + " " + mm + "," + yy)
                            .checkResult("Subjects", subject)
                            .checkResult("Address","address")
                            .checkResult("State and City", state + " " + city);
        $("#closeLargeModal").click();
        $("[id=firstName").shouldBe(visible);
    }
    @Test
    void fillFormPositiveWithKeys() {
//Test data
        String firstName = "Arven",lastName = "Nerva"
                ,Email = "arven@nina.win",gender = "Female"
                ,subject = "History",address = "Tawarwaith"
                ,state = "NCR",city = "Delhi"
                ,dd = "25",mm = "June",yy = "1957"
                ,element = "#submit",notClickableFromTop = "top"
                ,hobbie1 = "Sports",hobbie2 = "Reading",hobbie3 = "Music"
                ,targetToScroll1 = "#state", targetToScroll2 = "#city",
                uploadedFile = "04988436.webp";
//Fill up form
        Integer number = 1234567890;
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(Email)
                .setGender(gender)
                .setNumber(number)
                .setDateOfBirthWithKeys(dd, mm, yy)
                .setSubject(subject)
                .setHobbies(hobbie1).setHobbies(hobbie2).setHobbies(hobbie3)
                .upload(uploadedFile)
                .setAddress(address)
                .scrollToAndClick(targetToScroll1)
                .setState(state)
                .scrollToAndClick(targetToScroll2)
                .setCity(city)
                .cantClickElement(element,notClickableFromTop);
//Asserts
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationFormPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", Email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", Integer.toString(number))
                .checkResult("Date of Birth", dd + " " + mm + "," + yy)
                .checkResult("Subjects", subject)
                .checkResult("Address","address")
                .checkResult("State and City", state + " " + city);
        $("#closeLargeModal").click();
        $("[id=firstName").shouldBe(visible);
    }
}


