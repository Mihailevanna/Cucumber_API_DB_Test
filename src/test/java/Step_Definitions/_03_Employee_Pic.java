package Step_Definitions;

import Pages.Dialog;
import Pages.Navigation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _03_Employee_Pic {

    Dialog dia = new Dialog();
    Navigation navi = new Navigation();


    @And("Upload file")
    public void uploadFile(DataTable dataTable) {
        List<String> datalist = dataTable.asList(String.class);
        for (int i = 0; i < datalist.size(); i++) {
            dia.uploadPic(datalist.get(i));
        }

    }
}
