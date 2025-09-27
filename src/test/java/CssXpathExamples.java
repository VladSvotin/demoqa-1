import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples() {

        // <input type="email" class="inputtext login_form_input box" id="email"

        $("input#email").setValue("1");

        $x("//input[@id='email']").setValue("1");;

        $(byName("email")).setValue("1");

        //по классу
        $("[class=login_form_input_box]").setValue("1");
        $(".login_form_input_box").setValue("1");
        $(".inputtext.login_form_input_box").setValue("1");
        $("input.inputtext.login_form_input_box").setValue("1");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("1");

        // <div class="inputtext">
        //      <input type="email" class="login_form_input box" id="email"
        //   </div

        $("inputtext. login_form_input_box").setValue("1");
        $("inputtext").$("login_form_input_box").setValue("1");

        // <div> Hello </div>
        $x("//div[text()='Hello']").click();
        $(byText("Hello")).click();
    }
}
