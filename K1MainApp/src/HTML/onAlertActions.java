package HTML;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.web.WebEvent;

public class onAlertActions implements EventHandler<WebEvent<String>> {

    @Override
    public void handle(WebEvent<String> event) {
        new webManager().setStatusBoxColor("ORANGE");

        //new JavaBridge().setStatus(event);
        new JavaBridge().setStatus(event.getData());

        Runnable r = () -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(onAlertActions.class.getName()).log(Level.SEVERE, null, ex);
            }
            new webManager().setStatusBoxColor("GREEN");
        };
        Thread thr = new Thread(r);

        thr.start();
    }

}
