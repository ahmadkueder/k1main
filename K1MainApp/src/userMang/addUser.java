package userMang;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class addUser {

    String FormNAme;
    Stage st = k1mainapp.K1MainApp.getStage();
    AnchorPane center = (AnchorPane) st.getScene().lookup("#center");

    public addUser() {

    }

    public void addUserForm(String FromName) {
        
        try {
            // set the Add user From into center section
            AnchorPane root = FXMLLoader.load(getClass().getResource(FromName + ".fxml"));
            //root.setPrefWidth(Double.MAX_VALUE);
            //root.setPrefHeight(Double.MAX_VALUE);
            
            AnchorPane.setBottomAnchor(root, Double.MIN_VALUE);
            AnchorPane.setTopAnchor(root,Double.MIN_VALUE);
            AnchorPane.setLeftAnchor(root,Double.MIN_VALUE);
            AnchorPane.setRightAnchor(root,Double.MIN_VALUE);
            
            
            center.getChildren().add(root);

            System.out.println(center.getPrefWidth());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
