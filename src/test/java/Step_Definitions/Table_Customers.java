package Step_Definitions;

import Utilities.JDBC_Utilities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

import java.util.List;

public class Table_Customers extends JDBC_Utilities {

    List<List<String>> dataFromDB;

    @Given("Send {string} as a query")
    public void sendAsAQuery(String query) {
        dataFromDB = JDBC_Utilities.getData(query);
    }

    @And("Check data If its in Database")
    public void checkDataIfItsInDatabase(DataTable dataTable) {
        List<String> dataList = dataTable.asList(String.class);

        int count = 0;
        for (String data : dataList) {
            for (int i = 0; i < dataFromDB.size(); i++) {
                if (dataFromDB.get(i).get(0).equalsIgnoreCase(data)) {
                    count++;
                    break;
                }
            }

        }
        if (count == dataList.size()) {
            Assert.assertTrue(true);
        } else
            Assert.fail();
    }


    @And("Check that there are no spaces in table names")
    public void checkThatThereAreNoSpacesInTableNames() {
        for (int i = 0; i < dataFromDB.size(); i++) {
            Assert.assertEquals(dataFromDB.get(i).get(0).trim().split(" ").length, 1);
        }
    }

    @And("Check information on column")
    public void checkInformationOnColumn(DataTable dataTable) {
        List<List<String>> dataList = dataTable.asLists(String.class);
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).get(0).equalsIgnoreCase(dataFromDB.get(i).get(0))) {
                Assert.assertEquals(dataFromDB.get(i).get(1).toLowerCase(), dataList.get(i).get(1).toLowerCase());
            } else
                Assert.fail();
        }

    }
}
