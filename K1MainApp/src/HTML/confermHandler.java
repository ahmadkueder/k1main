package HTML;

import javafx.util.Callback;

public class confermHandler implements Callback<String, Boolean> {

    @Override
    public Boolean call(String param) {
        System.out.println(param);
        new JavaBridge().setStatus("EDIT OR DELITE ITEM.");
        System.out.println(param);
        boolean confirm = new dialogeManager().showConfitnDialog(param, "");
        if (confirm) {
            new JavaBridge().setStatus("Request sent");
        } else {
            new JavaBridge().setStatus("operation canceled");
        }
        return confirm;
    }
}
