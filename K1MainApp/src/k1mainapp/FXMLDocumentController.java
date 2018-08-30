package k1mainapp;

import HTML.webManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import jsonHandeling.lib;
import sections.topBtns;

/**
 *
 * @author ahmad
 */
public class FXMLDocumentController implements Initializable {

    lib readFile;

    @FXML
    private ScrollPane topBtnsContainer;

    @FXML
    private BorderPane complettBorderPane;
    @FXML
    private ScrollPane leftSection;
    @FXML
    private WebView center;

    @FXML
    private Text statusBar;
    @FXML
    private Rectangle boxColod;

    private static WebEngine eng;

    @FXML
    private ProgressBar prog;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            topBtnsContainer.setContent(new topBtns().printTopElements());
            webManager wm = new webManager(center, eng);

        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }

    }

}
