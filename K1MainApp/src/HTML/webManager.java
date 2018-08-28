package HTML;

import java.net.URL;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ProgressBar;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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

    public webManager(WebView wv, WebEngine we) {
        // init webBrowser
        we = wv.getEngine();
        we.getLoadWorker().stateProperty().addListener(new webEngineListener());

        we.getLoadWorker().progressProperty().addListener(new webEngineProgress());

        webManager.wv = wv;
        webManager.we = we;

    }

    // set Engine URL
    public void setURL(String urlName) {
        try {
            URL url = getClass().getResource("/HTML/" + urlName + ".html");

            //URL url = new URL("http://youtube.com");
            this.we.load(url.toExternalForm());
        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }

    }

    public void setJSobjectName(String jsName) {
        try {
            JSObject jsobject = (JSObject) we.executeScript(jsName);
            jsobject.setMember("java", new JavaBridge());
        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }
    }

    public void setWVempty() {
        webManager.we.loadContent("");
    }

    public ProgressBar getBar() {
        return bar;
    }

    public void setBar(ProgressBar bar) {
        this.bar = bar;
    }
}
