package HTML;

import javafx.event.EventHandler;
import javafx.scene.web.WebEvent;

public class onAlertActions implements EventHandler<WebEvent<String>> {

    @Override
    public void handle(WebEvent<String> event) {
        new webManager().setStatusBoxColor("ORANGE");
        //new JavaBridge().setStatus(event);
        new JavaBridge().setStatus(event.getData());
    }

}
