package HTML;

import java.io.File;
import java.net.URL;
import javafx.scene.control.ProgressBar;
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
    private ProgressBar bar;
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }

    public void setWVempty() {
        we.loadContent("");
    }

    public ProgressBar getBar() {
        return bar;
    }

    public void setBar(ProgressBar bar) {
        this.bar = bar;
    }
}
