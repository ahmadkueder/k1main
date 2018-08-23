package sections;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class leftSectionFunctions implements leftSectionFunctionsInterface {

    @Override
    public VBox userMang() {
        System.out.println("from : " + this.getClass().getMethods().length);
        return new VBox(new Button("Test"));
    }

    @Override
    public VBox productsMange() {
        System.out.println("from : " + this.getClass().getMethods().length);
        return new VBox(new Button("Test"));
    }

    @Override
    public VBox werehouseMange() {
        System.out.println("from : " + this.getClass().getMethods().length);
        return new VBox(new Button("Test"));
    }

}
