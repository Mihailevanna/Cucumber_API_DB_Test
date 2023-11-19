package Step_Definitions;

import Pages.Dialog;
import Pages.Navigation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class _04_AddUserFunction {

    Dialog dia = new Dialog();
    Navigation navi = new Navigation();

    @And("Select Option")
    public void selectOption(DataTable dataTable) {
        List<List<String>> datalist = dataTable.asLists(String.class);
        for (int i = 0; i < datalist.size(); i++) {
            dia.sendKeysMethod(dia.getWebElement(datalist.get(i).get(0)), datalist.get(i).get(1));

        }
    }


    @Then("Verify that Error Messages: displayed,red color and has Text {string}")
    public void verifyThatErrorMessagesDisplayedRedColorAndHasText(String message, DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);

        for (int i = 0; i < dataList.size(); i++) {
            Assert.assertTrue(dia.getWebElement(dataList.get(i)).isDisplayed());
            Assert.assertEquals(message, dia.getWebElement(dataList.get(i)).getText());
            Assert.assertEquals("rgb(235, 9, 16)", dia.getWebElement(dataList.get(i)).getCssValue("Color"));

        }

    }
}

