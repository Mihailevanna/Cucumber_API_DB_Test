package Step_Definitions;

import Pages.Dialog;
import Utilities.My_Methods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _05_Navigation {
    Dialog dia = new Dialog();

    @And("List of headers is Displayed and contains Text")
    public void listOfHeadersIsDisplayed(DataTable dataTable) {
        dia.getListOfHeaders();
        List<String> ListOfText = dataTable.asList(String.class);

        My_Methods.assertTextContains(dia.getListOfHeaders(), ListOfText);

    }
}
