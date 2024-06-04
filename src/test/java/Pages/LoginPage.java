package Pages;

import Utils.AppUtils;
import Utils.MobileDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;


public class LoginPage {

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public WebElement allowButton;

    @AndroidFindBy(id = "hurriyet.mobil.android:id/actionbar_home_profile")
    public WebElement profileIcon;

    @AndroidFindBy(id = "hurriyet.mobil.android:id/newsDetail_textView_topTitle")
    public WebElement profileHeader;

    @AndroidFindBy(id = "hurriyet.mobil.android:id/loginTextBtn")
    public WebElement loginButton;

    @AndroidFindBy(id = "hurriyet.mobil.android:id/login_title")
    public WebElement signInAndRegisterText;

    @AndroidFindBy(id = "hurriyet.mobil.android:id/login_editText_password")
    public WebElement passwordInput;

    @AndroidFindBy(id = "hurriyet.mobil.android:id/login_editText_email")
    public WebElement emailInput;

    @AndroidFindBy(id = "hurriyet.mobil.android:id/login_textView_continue")
    public WebElement continueButton;

    @AndroidFindBy(id = "hurriyet.mobil.android:id/textview_eposta")
    public WebElement usernameText;







    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(MobileDriver.get()), this);
    }


    public void login(String username, String password) {
        AppUtils.waitForVisibility(emailInput, 15);
        emailInput.sendKeys(username);
        AppUtils.waitForVisibility(passwordInput, 15);
        passwordInput.sendKeys(password);
        AppUtils.waitForClick(continueButton, 15);
        continueButton.click();


    }

    public void verifyText(WebElement element,String expectedText) {
        AppUtils.waitForVisibility(element,15);
        String actualText = element.getText();
        System.out.println("expected = " + expectedText);
        System.out.println("actual = " + actualText);
        assertEquals(expectedText,actualText);


    }


}
