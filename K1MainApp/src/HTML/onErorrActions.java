/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTML;

import javafx.event.EventHandler;
import javafx.scene.web.WebErrorEvent;

/**
 *
 * @author ahmad
 */
public class onErorrActions implements EventHandler<WebErrorEvent> {

    @Override
    public void handle(WebErrorEvent event) {
        System.out.println("ON ERORR : " + event.getMessage());
    }
    
}
