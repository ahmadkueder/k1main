package productsMange;

import HTML.webManager;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class existProducts implements EventHandler {

    @Override
    public void handle(Event event) {
        Button current = (Button) event.getTarget();
        String FormNAme = current.getId();
        try {
            new webManager().setURL(FormNAme);
        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }
    }

}
