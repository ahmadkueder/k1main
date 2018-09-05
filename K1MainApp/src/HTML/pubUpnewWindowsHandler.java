/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTML;

import javafx.scene.Scene;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 *
 * @author ahmad
 */
public class pubUpnewWindowsHandler implements Callback<PopupFeatures, WebEngine> {
    
    @Override
    public WebEngine call(PopupFeatures param) {
        
        Stage stage = new Stage(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        
        
        
        stage.initOwner(k1mainapp.K1MainApp.getStage());
        
        WebView wv2 = new WebView();

        stage.setScene(new Scene(wv2));
        stage.show();
        return wv2.getEngine();
        
    }
    
}
