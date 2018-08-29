package HTML;

import java.io.File;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

/**
 *
 * @author ahmad
 */
public class webManager {

    public webManager() {

    }

    private static WebView wv;
    private static WebEngine we;

    public webManager(WebView wv, WebEngine we) {
        // init webBrowser
        we = wv.getEngine();
        we.setJavaScriptEnabled(true);
        we.getLoadWorker().stateProperty().addListener(new webEngineListener());

        we.getLoadWorker().progressProperty().addListener(new webEngineProgress());

        webManager.wv = wv;
        webManager.we = we;

    }

    // set Engine URL
    public boolean setURL(String urlName) {
        System.out.println("from set URL");
        Stage st = k1mainapp.K1MainApp.getStage();
        javafx.scene.shape.Rectangle statusBar = (javafx.scene.shape.Rectangle) st.getScene().lookup("#boxColod");
        try {
            //System.out.println(new File("/HTML/main.css").getPath());

            //URL url = new URL("/HTML/" + urlName + ".html");
            //URL url = new URL("http://youtube.com");
            if (new File("HTML/" + urlName + ".html").exists()) {
                we.load(new File("HTML/" + urlName + ".html").toURI().toString());
            } else {
                we.loadContent("<h1>File Not created yet.</h1>");
                setStatusBoxColor("RED");
            }

            return true;
        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }

        return false;
    }

    public boolean setJSobjectName(String jsName) {

        try {
            JSObject jsobject = (JSObject) we.executeScript(jsName);
            jsobject.setMember("java", new JavaBridge());
            return true;
        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }
        return false;
    }

    public void setWVempty() {
        we.loadContent("");
    }

    public void setStatusBoxColor(String val) {
        Stage st = k1mainapp.K1MainApp.getStage();
        javafx.scene.shape.Rectangle statusBar = (javafx.scene.shape.Rectangle) st.getScene().lookup("#boxColod");
        statusBar.setFill(Color.valueOf(val));
        System.out.println("set Box Color");
    }

    public void setProgressValue(double value) {
        ProgressBar bar = (ProgressBar) k1mainapp.K1MainApp.getStage().getScene().lookup("#prog");

        bar.setProgress((double) value);

        if ((double) value == 1.0) {
            bar.setProgress((double) 0);
        }

    }

}
