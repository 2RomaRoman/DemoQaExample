package pages.components;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationFormPage {

    CalenderComponent calenderComponent = new CalenderComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    SelenideElement firstname = $("[id=firstName"),
                    lastname = $("[id=lastName"),
                    number = $("[id=userNumber"),
                    email = $("[id=userEmail"),
                    address = $("#currentAddress"),
                    subject = $("#subjectsInput"),
                    gender = $("#genterWrapper"),
                    hobbies = $("#hobbiesWrapper"),
                    dateOfBirth = $("[id=dateOfBirthInput]"),
                    cityWrapper = $("#stateCity-wrapper"),
                    stateWrapper = $("#stateCity-wrapper"),
                    fileTo = $("#uploadPicture");

    public RegistrationFormPage openPage() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('fixedban').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    return this;
    }
    public RegistrationFormPage setCity(String value)  {
        cityWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setState(String value)  {
        stateWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage upload(String value)  {
        fileTo.uploadFromClasspath(value);
        return this;
    }
    public RegistrationFormPage setFirstName(String value)  {
        firstname.setValue(value);
        return this;
    }
    public RegistrationFormPage setLastName(String value) {
        lastname.setValue(value);
        return this;
    }
    public RegistrationFormPage setNumber(int value) {
        number.setValue(Integer.toString(value));
        return this;
    }
    public RegistrationFormPage setEmail(String value) {
        email.setValue(value);
        return this;
    }
    public RegistrationFormPage setAddress(String value) {
        address.setValue(value);
        return this;
    }
    public RegistrationFormPage setSubject(String value){
        subject.sendKeys(value);
        subject.pressEnter();
        return this;
    }

    public RegistrationFormPage setGender(String value) {
         gender.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirth.click();
        calenderComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationFormPage setDateOfBirthWithKeys(String day, String month, String year) {
        dateOfBirth.sendKeys(Keys.LEFT_CONTROL+"A");
        dateOfBirth.sendKeys(day + " " + month + " " + year + " ");
        dateOfBirth.pressEnter();
        return this;
    }
    public RegistrationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }
    public void cantClickElement(String element, String notClickableFrom) {
        SelenideElement notClickableElement = $(element);
        int h = notClickableElement.getRect().height;
        int w = notClickableElement.getRect().width;
        if (notClickableFrom == "top") {
            h = h - 30;
            w = w - 70;
        } else if (notClickableFrom == "bottom") {
            h = h + 30;
            w = w + 70;
        }else
            System.out.println("invalid value");
        Actions builder = new Actions(getWebDriver());
        builder.moveToElement(notClickableElement,-w,-h).click().build().perform();
    }
    public RegistrationFormPage scrollToAndClick (String value) {
        if($(value).is(visible)) {
            $(value).scrollTo().click();
        } else
            $(value).click();
        return this;
    }
}


