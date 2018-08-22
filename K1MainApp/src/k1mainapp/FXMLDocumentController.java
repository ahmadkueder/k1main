package k1mainapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import jsonHandeling.implementation;
import jsonHandeling.lib;

public class FXMLDocumentController implements Initializable {

    lib readFile;

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // set File Name 
        lib lib = new implementation();
        try {
            lib.returnJsonAsString("./src/USAG/Stroktur.json");
            label.setText(String.valueOf(lib.getSpecificArray("columns").length()));
        } catch (Exception ex) {
            
        }

    }

}
