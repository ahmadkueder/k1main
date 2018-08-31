package HTML;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class dialogeManager {

    /**
     * @param String msg
     * @param String title
     * @explane to show confirm ok and cancle dialog with title and
     * <br> the main msg 
     **/
    public boolean showConfitnDialog(String msg, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(msg);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

}
