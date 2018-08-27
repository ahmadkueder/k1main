/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enginetest;

import HTML.JavaBridge;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.text.Document;
import netscape.javascript.JSObject;

/**
 *
 * @author ahmad
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private WebView Web;
    @FXML
    private Button btn;

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        WebEngine eng = Web.getEngine();
        eng.load(getClass().getResource("DOM.html").toString());
        eng.setJavaScriptEnabled(true);

        try {

            eng.setOnError(event -> {
                System.out.println(event);
            });

            //eng.setJavaScriptEnabled(true);
            Document doc = (Document) eng.getDocument();
            try {

                eng.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                        if (newValue == oldValue.SUCCEEDED) {
                            JSObject window = (JSObject) eng.executeScript("document");
                            window.setMember("java", new JavaBridge());
                            eng.executeScript("console.log = function(message) { java.log(message); }"); // Now where ever console.log is called in you
                        }
                    }
                });

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
;

}
