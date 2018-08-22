package k1mainapp;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            lib.returnJsonAsString("./src/newjson.json");
            label.setText(String.valueOf(lib.getSpecificInt("age")));
        } catch (Exception ex) {
            
        }

    }

}
