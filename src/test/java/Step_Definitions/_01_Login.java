package Step_Definitions;

import Pages.Dialog;
import Pages.Navigation;
import Utilities.Base_Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;


public class _01_Login {
    Dialog dia = new Dialog();
    Navigation navi = new Navigation();


    @Given("Navigate to Web Page")
    public void navigateToWebPage() {
        Base_Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }


    @And("Enter data in Text Box")
    public void enterDataInTextBox(DataTable dataTable) {
        List<List<String>> datalist = dataTable.asLists(String.class);
        for (int i = 0; i < datalist.size(); i++) {
            String inputData = datalist.get(i).get(1);
            CharSequence actualKey = (inputData != null && !inputData.isEmpty()) ? inputData : "";
            dia.clearText(dia.getWebElement(datalist.get(i).get(0)));
            dia.sendKeysMethod(dia.getWebElement(datalist.get(i).get(0)), actualKey.toString());
        }
    }

    @When("Click on navigation element")
    public void clickOnNavigationElement(DataTable dataTable) {
        List<String> datalist = dataTable.asList(String.class);
        for (int i = 0; i < datalist.size(); i++) {
            navi.clickMethod(navi.getWebElement(datalist.get(i)));
        }
    }

    @Then("Navigation element should be displayed")
    public void navigationElementShouldBeDisplayed(DataTable dataTable) {
        List<String> datalist = dataTable.asList(String.class);
        for (int i = 0; i < datalist.size(); i++) {
            navi.waitUntilVisible(navi.getWebElement(datalist.get(i)));
            Assert.assertTrue(navi.getWebElement(datalist.get(i)).isDisplayed());
        }

    }

    @Then("Dialog element should be displayed")
    public void dialogElementShouldBeDisplayed(DataTable dataTable) {
        List<String> datalist = dataTable.asList(String.class);
        for (int i = 0; i < datalist.size(); i++) {
            dia.waitUntilVisible(dia.getWebElement(datalist.get(i)));
            Assert.assertTrue(dia.getWebElement(datalist.get(i)).isDisplayed());
        }


    }
}
