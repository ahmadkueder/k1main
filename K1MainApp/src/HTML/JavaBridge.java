package HTML;

import USAG.poster;
import USAG.propsHandel;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ahmad
 */
public class JavaBridge {

    /**
     *
     */
    public void exit() {
        try {
            if (Platform.isFxApplicationThread()) {
                Platform.exit();
            } else {
                this.log("This Noth Apps");
            }
        } catch (Exception e) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println(e.getMessage() + " - " + getClass().getName() + " - " + name);
        }

    }

    /**
     *
     * @param text
     * @return
     */
    public String log(String text) {
        try {
            System.out.println(text);
            return "";
        } catch (Exception e) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println(e.getMessage() + " - " + getClass().getName() + " - " + name);
        }
        return "";
    }

    /**
     *
     * @param obj
     */
    public void obje(Object obj) {
        try {
            System.out.println(obj);
        } catch (Exception e) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println(e.getMessage() + " - " + getClass().getName() + " - " + name);
        }

    }

    /**
     *
     * @return
     */
    public String getLink_() {

        try {
            String apiLink =new propsHandel().getProp("APIlink");
            return apiLink;
        } catch (Exception ex) {
            System.out.println("Class name : " + getClass().getName() + ", Message : " + ex.getMessage());
        }
        return "";
    }

    // To send and get data from Server by selecting wich method i wont
    /**
     *
     * @param methodName
     * @param data
     * @return
     */
    public String passData(String methodName, String data) {

        try {

            poster poster = new poster(methodName, data);
            if (poster.isDone()) {
                return poster.getserverResponce();
            } else {
                return poster.getConnectionStatus();
            }

        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }

        return "";

    }

    /**
     *
     * @param message
     */
    public void setStatus(String message) {
        Stage st = k1mainapp.K1MainApp.getStage();
        Text statusBar = (Text) st.getScene().lookup("#statusBar");
        statusBar.setText(message);
    }

    /**
     *
     * @param color
     */
    public void setRectangeColor(String color) {
        Stage st = k1mainapp.K1MainApp.getStage();
        Rectangle statusBar = (Rectangle) st.getScene().lookup("#boxColod");
        statusBar.fillProperty().setValue(Color.valueOf(color));
    }

}
