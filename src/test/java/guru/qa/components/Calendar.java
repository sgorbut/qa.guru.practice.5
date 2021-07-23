package guru.qa.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class Calendar {
    public void setDate(String day, String month, String year){
        $("#dateOfBirthInput").clear(); // date of birth
        $(".react-datepicker__month-select").selectOption(month);   // month
        $(".react-datepicker__year-select").selectOption(year); // year
        $(".react-datepicker__day--0"+day).click(); // day
    }
}