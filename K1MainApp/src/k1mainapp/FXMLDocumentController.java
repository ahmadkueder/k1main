package k1mainapp;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import jsonHandeling.lib;
import sections.topBtns;

public class FXMLDocumentController implements Initializable {

    lib readFile;

    @FXML
    private ScrollPane topBtnsContainer;

    @FXML
    private BorderPane complettBorderPane;
    @FXML
    private ScrollPane leftSection;
    @FXML
    private AnchorPane ancg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            topBtnsContainer.setContent(new topBtns().printTopElements());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
