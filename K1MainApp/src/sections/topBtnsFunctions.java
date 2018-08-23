package sections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import k1mainapp.K1MainApp;

public class topBtnsFunctions implements topBtnsFunctionsInterFace {

    Scene mainScene = K1MainApp.getStage().getScene();
    final String leftSectionID = "#leftSection";
    ScrollPane leftSection = (ScrollPane) mainScene.lookup(leftSectionID);

    @Override
    public void userMang(Button thisBtn) {
        leftSection.setContent(this.invokeMethodLeftSections(thisBtn.getId()));
    }

    @Override
    public void productsMange(Button thisBtn) {

    }

    @Override
    public void werehouseMange(Button thisBtn) {

    }

    // Section geter
    public VBox invokeMethodLeftSections(String sectionToCall) {
        Class clas;
        try {
            clas = Class.forName("sections.leftSectionFunctions");

            Object instance = clas.newInstance();

            Method method = clas.getDeclaredMethod(sectionToCall);
            
            return (VBox) method.invoke(instance);

        } catch (ClassNotFoundException | IllegalAccessException
                | InstantiationException
                | NoSuchMethodException | SecurityException | InvocationTargetException | IllegalArgumentException e) {
            System.out.println("IllegalArgumentException : " + this.getClass().getName() + " -- " + e.getMessage());

        }
        return new VBox(new Button("tt"));
    }

}
