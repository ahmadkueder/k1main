/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTML;

import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.util.Callback;

/**
 *
 * @author ahmad
 */
public class pubUpnewWindowsHandler implements Callback<PopupFeatures, WebEngine> {

    @Override
    public WebEngine call(PopupFeatures param) {
        System.out.println("pagepubup");
        return new WebEngine();
    }

}
