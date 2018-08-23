package sections;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class leftSectionFunctions implements leftSectionFunctionsInterface {

    @Override
    public VBox userMang(String fromTopsBtns) {
        
        return new VBox(new Button(fromTopsBtns));
    }

    @Override
    public VBox productsMange(String fromTopsBtns) {

        return new VBox(new Button(fromTopsBtns));
    }

    @Override
    public VBox werehouseMange(String fromTopsBtns) {
        
        return new VBox(new Button(fromTopsBtns));
    }

}
