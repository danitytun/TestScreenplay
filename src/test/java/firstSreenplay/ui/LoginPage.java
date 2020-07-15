package firstSreenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USERNAME = 
            Target.the("Username field").located(By.xpath("//input[@name='login']"));
    public static final Target PASSWORD =
            Target.the("Password field").located(By.xpath("//input[@name='password']"));
    public static final Target LOGIN =
            Target.the("Login button").located(By.xpath("//input[@class='button primary']"));
    public static final Target MESSAGE_BOX =
            Target.the("Message box").located(By.xpath("//div[@class='scrollContainer']"));
    public static Target MESSAGE_CONTENT = Target.the("Message content")
            .located(By.xpath("//li[@class='panel Notice DismissParent notice_notice_confirm_email ']//div[@class='baseHtml noticeContent']//p[1]"));
}
