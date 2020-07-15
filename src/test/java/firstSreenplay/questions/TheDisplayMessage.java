package firstSreenplay.questions;

import firstSreenplay.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TheDisplayMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.MESSAGE_BOX, isVisible()).forNoMoreThan(10).seconds()
        );
        return Text.of(LoginPage.MESSAGE_CONTENT).viewedBy(actor).asString();
    }

    public static Question<String> GetTitle()
    {
        return new TheDisplayMessage();
    }
}
