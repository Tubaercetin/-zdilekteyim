import com.google.common.collect.ImmutableMap;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest {
    @Step("<wait> saniye kadar bekle")
    public void waitForseconds(int wait) throws InterruptedException {
        Thread.sleep(1000 * wait);
    }

    @Step("id <id> li elemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        System.out.println(id + "elementine tıklandı");

    }

    @Step("xpath <xpath> li elemente tıkla")
    public void clickByxpath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        System.out.println(xpath + "elementine tıklandı");

    }

    @Step("<scroll edilir>")
    public void scroll(String scroll) {
        TouchAction ts = new TouchAction(appiumDriver);
        ts.press(PointOption.point(540, 1540)).moveTo(PointOption.point(540, 422)).release().perform();
        logger.info("Scroll edildi.");
    }

    @Step("Random ürün seç")
    public void selectRandom(){
        Random rdn = new Random();
        List<MobileElement> us = appiumDriver.findElements(By.xpath("//*[@resource-id = 'com.ozdilek.ozdilekteyim:id/recyclerView']/android.widget.FrameLayout"));
        System.out.println("pd"  +us);
        MobileElement element =  us.get(rdn.nextInt(us.size()));
        System.out.println("element"  +element);
        element.click();
    }
    @Step("<id> İd'li elemente <text> değerini yaz")
    public void kullaniciAdi (String id,String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        System.out.println(id + "elementini bul ve " + text + " değerini yaz");
    }
}


