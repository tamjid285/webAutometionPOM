package parabank.parasoft.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import parabank.parasoft.com.utill.General;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;




public abstract class Page {

    WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(General.WAIT_TIME));

    }

    public abstract String getPageTittle();

    public abstract WebElement getWebElement(By locator);

    public abstract List<WebElement> getWebElements(By selector);

    public abstract void waitForWebElement(By locator);

    public <T extends BasePage> T getInstance(Class<T> tClass) {

        try {
            return tClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }


}

