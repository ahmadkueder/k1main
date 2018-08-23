package sections;

import javafx.scene.layout.VBox;

public class leftBtns {

    VBox btnContainer;

    public VBox printLeftSectionBtns() {
        btnContainer = new VBox();
        btnContainer.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        return btnContainer;
    }
    
}
