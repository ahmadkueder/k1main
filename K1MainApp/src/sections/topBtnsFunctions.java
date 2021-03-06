package sections;

import HTML.webManager;
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
        new webManager().setWVempty();
        leftSection.setContent(this.invokeMethodLeftSections(thisBtn.getId()));
    }

    @Override
    public void productsMange(Button thisBtn) {
        new webManager().setWVempty();
        leftSection.setContent(this.invokeMethodLeftSections(thisBtn.getId()));
    }

    @Override
    public void werehouseMange(Button thisBtn) {
        new webManager().setWVempty();
        leftSection.setContent(this.invokeMethodLeftSections(thisBtn.getId()));
    }

    @Override
    public void getWebSite(Button thisBtn) {
        new webManager().setScureURL("http://k1computer.de/app");
        
    }

    // Section geter
    public VBox invokeMethodLeftSections(String sectionToCall) {
        Class clas;
        try {
            clas = Class.forName("sections.leftBtns");

            Object instance = clas.newInstance();

            Method method = clas.getDeclaredMethod("printLeftSectionBtns", String.class);

            return (VBox) method.invoke(instance, sectionToCall);

        } catch (ClassNotFoundException | IllegalAccessException
                | InstantiationException
                | NoSuchMethodException | SecurityException | InvocationTargetException | IllegalArgumentException e) {
            System.out.println("IllegalArgumentException : " + this.getClass().getName() + " -- " + e.getMessage());

        }
        return null;
    }

}
