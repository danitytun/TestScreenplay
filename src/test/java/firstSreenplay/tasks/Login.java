package firstSreenplay.tasks;

import firstSreenplay.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private String username;
    private String password;

    public Login(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    @Override
    @Step("{0} attempt to login with her credential #username and #password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.username).into(LoginPage.USERNAME),
                Enter.theValue(this.password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN)
        );
    }

    public static LoginBuilder withUserNam(String username) {
        return new LoginBuilder(username);
    }

    public static class LoginBuilder{
        private String username;
        public LoginBuilder(String username)
        {
            this.username = username;
        }

        public Task andPassword(String password) {
            return instrumented(Login.class,this.username, password);
        }
    }
}
