package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
public class CalenderComponent {

    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__year-select").selectOptionByValue((year));
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();

    }

}
