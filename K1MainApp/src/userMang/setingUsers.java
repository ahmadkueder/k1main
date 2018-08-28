/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userMang;

import HTML.webManager;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author ahmad
 */
public class setingUsers implements EventHandler {

    @Override
    public void handle(Event event) {
        Button current = (Button) event.getTarget();
        String FormNAme = current.getId();
        try {

            new webManager().setURL(FormNAme);
            new webManager().setJSobjectName("window");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
