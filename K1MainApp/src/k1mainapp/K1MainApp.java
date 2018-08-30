/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k1mainapp;

import java.awt.Desktop;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class K1MainApp extends Application {

    static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        K1MainApp.stage = stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            //stage.setFullScreen(true);

            System.out.println( Desktop.getDesktop().isSupported(Desktop.Action.OPEN));
            
            
            setStage(stage);
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();

            stage.setTitle("Ahmad");

//        stage.setX(bounds.getMinX());
//        stage.setY(bounds.getMinY());
//        stage.setWidth(bounds.getWidth());
//        stage.setHeight(bounds.getHeight());
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

            AnchorPane left = new AnchorPane();
            left.setScaleX(100);
            left.setScaleY(200);

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }
    }

    public static void main(String[] args) throws IOException, Exception {
        launch(args);

    }

// return grid pane
    public GridPane gridDes() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);

        for (int i = 0; i < 50; i++) {
            grid.add(new Button("sss"), 0, i);
        }

        return grid;
    }

}
