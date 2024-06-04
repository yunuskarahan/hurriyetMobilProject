package Utils;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppUtils {

    public static WebElement waitForVisibility(WebElement element, int seconds) {

        WebDriverWait wait = new WebDriverWait(MobileDriver.get(), Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static WebElement waitForClick(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(MobileDriver.get(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void verifyText(WebElement element, int seconds, String expectedText) {
        waitForVisibility(element, seconds);
        String actualText = element.getText();
        System.out.println("expectedText = " + expectedText + " actualText= " + actualText);
        Assert.assertEquals(expectedText, actualText);

    }

    public static WebElement scrollElementWithTextForAndroid(String attribute, String text) {
        //\""+"ADD TO CART"+"\"  bu şekilde de kullanabilirsin

        return MobileDriver.get().findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollIntoView(new UiSelector()." + attribute + "(\"" + text + "\").instance(0))"));
    }


    public static void scroll() {
        Dimension size = MobileDriver.get().manage().window().getSize();
        System.out.println("Window size: " + size);
        Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
        int bottom = midPoint.y + (int) (midPoint.y * 0.25);
        int top = midPoint.y - (int) (midPoint.y * 0.25);
        Point start = new Point(midPoint.x, bottom);
        System.out.println("start = " + start);
        Point end = new Point(midPoint.x, top);
        System.out.println("end = " + end);
        scrollCode(start, end, Duration.ofMillis(1000)); // duration içerisinde scroll yaparken ki bekleme süresini belirtiyoruz

    }

    public static void scrollCode(Point start, Point end, Duration duration) {
        PointerInput pointerInput = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe = new Sequence(pointerInput,0);
        swipe.addAction(pointerInput.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),start.x,start.y));
        swipe.addAction(pointerInput.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(pointerInput.createPointerMove(duration,PointerInput.Origin.viewport(),end.x, end.y));
        swipe.addAction(pointerInput.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        MobileDriver.get().perform(ImmutableList.of(swipe));



    }
}