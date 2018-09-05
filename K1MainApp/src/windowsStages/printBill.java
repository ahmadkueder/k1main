package windowsStages;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class printBill extends Stage {

    public static final String SMALL_80MM = "80MM";
    public static final String SMALL_A4 = "A4";

    public printBill(String Size, Parent root) {
        Stage st = new Stage();
        switch (Size) {
            case "A4":
                Scene se = new Scene(root);
                break;
        }
    }

}
