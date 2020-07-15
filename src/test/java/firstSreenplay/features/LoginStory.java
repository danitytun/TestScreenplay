package firstSreenplay.features;

import firstSreenplay.questions.TheDisplayMessage;
import firstSreenplay.tasks.Login;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class LoginStory {
    Actor anna = Actor.named("Anna");

    @Managed
    WebDriver herDriver;

    @Before
    public void initActorAbility(){
        anna.can(BrowseTheWeb.with(herDriver));
    }

    @Test
    //public void  Show_homepage_when_login_with_valid_credential()
    public void Show_caution_message_when_login_with_account_not_authentication()
    {
        givenThat(anna).wasAbleTo(Open.url("https://forum.vietdesigner.net/login"));
        when(anna).attemptsTo(
                Login.withUserNam("test1test").andPassword("12345Aa@")
        );
        then(anna).should(
                seeThat(TheDisplayMessage.GetTitle(),
                        equalTo("Tài khoản của bạn hiện đang chờ xác nhận. Link xác nhận đã được gửi đến email của bạn là: test1test@gmail.com. Hãy vào email để kiểm tra và ấn vào link xác nhận tài khoản nhé."))
        );
    }
}
