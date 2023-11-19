package Step_Definitions;

import Pages.Dialog;
import Pages.Navigation;
import Utilities.Base_Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;


import java.util.List;

public class _02_PersonalInfo {
    Dialog dia = new Dialog();
    Navigation navi = new Navigation();


    @And("Delete old info and Enter data in Text Box")
    public void deleteOldInfoAndEnterDataInTextBox(DataTable dataTable) {
        List<List<String>> datalist = dataTable.asLists(String.class);
        Actions actions = new Actions(Base_Driver.getDriver());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < datalist.size(); i++) {
            CharSequence actualKey = (datalist.get(i).get(1) != null && !datalist.get(i).get(1).isEmpty()) ? datalist.get(i).get(1) : "";

            actions.click(dia.getWebElement(datalist.get(i).get(0)))
                    .sendKeys(Keys.chord(Keys.COMMAND, "a"))
                    .click(dia.getWebElement(datalist.get(i).get(0)))
                    .sendKeys(Keys.DELETE)
                    .sendKeys(actualKey)
                    .build()
                    .perform();
        }
    }

    @When("Click on dialog element")
    public void clickOnDialogElement(DataTable dataTable) {
        List<String> datalist = dataTable.asList(String.class);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < datalist.size(); i++) {

            dia.clickMethod(dia.getWebElement(datalist.get(i)));
        }
    }

    @Then("Verification")
    public void verification(DataTable dataTable) {
        List<List<String>> dataList = dataTable.asLists(String.class);
        for (int i = 0; i < dataList.size(); i++) {
            dia.waitUntilVisible(dia.getWebElement(dataList.get(i).get(0)));
            Assert.assertTrue(dia.getWebElement(dataList.get(i).get(0)).getText().toLowerCase().contains(dataList.get(i).get(1).toLowerCase()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
