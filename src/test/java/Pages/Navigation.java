package Pages;

import Utilities.Base_Driver;
import Utilities.My_Methods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation extends My_Methods {
    public Navigation() {
        PageFactory.initElements(Base_Driver.getDriver(), this);
    }

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement loginButton;
    @FindBy(xpath = "(//ul[@class=\"oxd-main-menu\"]/li)[6]")
    private WebElement myInfo;

    @FindBy(xpath = "(//ul[@class=\"oxd-main-menu\"]/li)[1]")
    private WebElement admin;
    @FindBy(xpath = "(//ul[@class=\"oxd-main-menu\"]/li)[8]")
    private WebElement dashboard;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/span")
    private WebElement userManagement;
    @FindBy(xpath = "//a[text()='Users']")
    private WebElement userButton;

    public WebElement getWebElement(String stringElement) {
        return switch (stringElement) {
            case "loginButton" -> this.loginButton;
            case "dashboard" -> this.dashboard;
            case "myInfo" -> this.myInfo;
            case "admin" -> this.admin;
            case "userManagement" -> this.userManagement;
            case "userButton" -> this.userButton;
            default -> null;
        };
    }


}
