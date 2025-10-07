import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HW1 {

    @BeforeAll
    static void beforeAll(){
        Configuration.browser = "chrome";
        Configuration.browserVersion = "113";
        Configuration.browserSize = "1920x1080";
//        Configuration.browserSize = "1024x768";
        Configuration.baseUrl ="https://demoqa.com";
    }

    @Test
    void hwTest1(){

        String userName = "Vlad";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");//удаляет баннер через ЖС
        executeJavaScript("$('footer').remove()");//удаляет футер, нижняя часть страницы

        $("#firstName").setValue("Vlad");
        $("#lastName").setValue("Vlad");
        $("#userEmail").setValue("Vlad@svot.com");
        $("#userNumber").setValue("89878355473");
        $("#currentAddress").setValue("Sadovaya");

        $("#gender-radio-1").parent().click();//good
        $("#genterWrapper").$(byText("Other")).click();//best


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1994");
        //css not
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        //xpath not
//        $x("//*[@class='react-datepicker__day--030'][not(contains(@class, react-datepicker__day--outside-month))]").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();//best
//        $("#hobbies-checkbox-3").click();//good
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));//good
        $("#uploadPicture").uploadFromClasspath("img/1.png");//best
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();


        sleep(5000);
        $("#submit").scrollIntoView(true).click();

        sleep(5000);
        $(".modal-dialog").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Vlad@svot.com"));

        closeWebDriver();
    }
}
