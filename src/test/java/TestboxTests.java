import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestboxTests {


    @BeforeAll
    static void beforeAll(){
        Configuration.browser = "chrome";
        Configuration.browserVersion = "113";
        Configuration.browserSize = "1920x1080";
//        Configuration.browserSize = "1024x768";
        Configuration.baseUrl ="https://demoqa.com";
    }

    @Test
    void fillFormTest(){

        open("/text-box");
//        sleep(20000);
//        $("#userName").setValue("Vlad");
//        $("[id=userName]").setValue("Vlad");
//        $("[id=userEmail]").setValue("Vlad");
//        $("[id=currentAddress]").setValue("Vlad");
//        $("[id=permanentAddress]").setValue("Vlad");


        $("#userName").setValue("Vlad");
        $("#userEmail").setValue("Vlad@svot.com");
        $("#currentAddress").setValue("Klochkova");
        $("#permanentAddress").setValue("Sadovaya");
        $("#submit").click();
        $("#output").scrollIntoView(true).shouldHave(text("Vlad"), text("Vlad@svot.com"), text("Klochkova"), text("Sadovaya"));
        closeWebDriver();
    }




}
