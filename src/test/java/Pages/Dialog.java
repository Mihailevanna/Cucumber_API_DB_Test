package Pages;

import Utilities.Base_Driver;
import Utilities.My_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dialog extends My_Methods {
    public Dialog() {
        PageFactory.initElements(Base_Driver.getDriver(), this);
    }

    @FindBy(css = "div[class=\"oxd-toast-start\"]")
    private WebElement messageShow;

    @FindBy(css = "input[name=\"username\"]")
    private WebElement userName;
    @FindBy(css = "input[type=\"password\"]")
    private WebElement password;
    @FindBy(css = "div[class=\"oxd-alert-content oxd-alert-content--error\"]")
    private WebElement alertError;

    @FindBy(css = "input[placeholder=\"First Name\"]")
    private WebElement firstNameField;

    @FindBy(css = "input[placeholder=\"Last Name\"]")
    private WebElement lastNameField;
    @FindBy(css = "button[type=\"submit\"]")
    private WebElement saveButton;
    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[3]")
    private WebElement employeeID;
    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[5]")
    private WebElement employeeDL;
    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[6]")
    private WebElement employeeDLExpire;
    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[7]")
    private WebElement employeeSSN;
    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[8]")
    private WebElement employeeSIN;
    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[9]")
    private WebElement employeeDOB;
    @FindBy(xpath = "//span[text()=\"Required\"]")
    private WebElement errorMessage;
 @FindBy(css = "img[class=\"employee-image\"]")
    private WebElement employeeImage;
 @FindBy(css = "i[class=\"oxd-icon bi-plus\"]")
    private WebElement addImage;
 @FindBy(xpath = "//span[text()=\"Attachment Size Exceeded\"]")
 private WebElement errorImageMessage;
 @FindBy(xpath = "(//button[@type=\"button\"])[5]")
 private WebElement addEmployee;
@FindBy(css = "div[class=\"oxd-select-text oxd-select-text--active\"]")
 private WebElement userRole;

@FindBy(xpath = "(//div[@role='option'])[3]")
 private WebElement essOption;
@FindBy( css= "input[placeholder=\"Type for hints...\"]")
 private WebElement employerName;
@FindBy( css= "div[class=\"oxd-autocomplete-dropdown --positon-bottom\"]")
 private WebElement employerNameSelect;
@FindBy( xpath= "(//div[@class=\"oxd-select-text-input\"])[2]")
 private WebElement statusEmployee;
@FindBy( xpath= "(//div[@role=\"option\"])[2]")
 private WebElement enableStatusOption;
@FindBy( xpath= "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
 private WebElement usernameEmployee;
@FindBy( css= "input[type=\"password\"]")
 private WebElement passwordEmployee;
@FindBy( xpath= "(//input[@type=\"password\"])[2]")
 private WebElement confirmPasswordEmployee;
@FindBy( xpath= "//span[text()=\"Already exists\"]")
 private WebElement errorText;

@FindBy( xpath= "//span[text()=\"Required\"]")
 private WebElement requiredMessageList;
@FindBy( xpath= "//span[text()=\"Passwords do not match\"]")
 private WebElement passwordDontMatch;
@FindBy( xpath= "//span[text()=\"Invalid\"]")
 private WebElement nameErrorMessage;
@FindBy( css= "div[role=\"columnheader\"]")
 private List<WebElement> ListOfHeaders;

    public List<WebElement> getListOfHeaders() {
        return ListOfHeaders;
    }

    public WebElement getWebElement(String stringElement) {
        return switch (stringElement) {
            case "messageShow" -> this.messageShow;
            case "userName" -> this.userName;
            case "password" -> this.password;
            case "alertError" -> this.alertError;
            case "firstNameField" -> this.firstNameField;
            case "lastNameField" -> this.lastNameField;
            case "saveButton" -> this.saveButton;
            case "employeeID" -> this.employeeID;
            case "employeeDL" -> this.employeeDL;
            case "employeeSSN" -> this.employeeSSN;
            case "employeeSIN" -> this.employeeSIN;
            case "employeeDLExpire" -> this.employeeDLExpire;
            case "employeeDOB" -> this.employeeDOB;
            case "errorMessage" -> this.errorMessage;
            case "employeeImage" -> this.employeeImage;
            case "addImage" -> this.addImage;
            case "errorImageMessage" -> this.errorImageMessage;
            case "addEmployee" -> this.addEmployee;
            case "userRole" -> this.userRole;
            case "essOption" -> this.essOption;
            case "employerName" -> this.employerName;
            case "statusEmployee" -> this.statusEmployee;
            case "enableStatusOption" -> this.enableStatusOption;
            case "usernameEmployee" -> this.usernameEmployee;
            case "passwordEmployee" -> this.passwordEmployee;
            case "confirmPasswordEmployee" -> this.confirmPasswordEmployee;
            case "employerNameSelect" -> this.employerNameSelect;
            case "errorText" -> this.errorText;
            case "requiredMessageList" -> this.requiredMessageList;
            case "passwordDontMatch" -> this.passwordDontMatch;
            case "nameErrorMessage" -> this.nameErrorMessage;
            default -> null;
        };
    }
}
