package HTML;

import USAG.propsHandel;
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
        wv.setContextMenuEnabled(false);

        we.getLoadWorker().stateProperty().addListener(new webEngineListener());

        we.getLoadWorker().progressProperty().addListener(new webEngineProgress());

        we.setOnAlert(new onAlertActions());

        we.setOnError(new onErorrActions());

        we.setConfirmHandler(new confermHandler());

        we.setOnStatusChanged(new onStatusChanges());

        we.setCreatePopupHandler(new pubUpnewWindowsHandler());

        java.net.CookieHandler.setDefault(new java.net.CookieManager());

        we.setUserAgent("kkkk");


        webManager.wv = wv;
        webManager.we = we;

    }

    // set Engine URL
    public boolean setURL(String urlName) {
        try {
            we.load(new propsHandel().getProp("pagesLink") + urlName + ".php");
            new JavaBridge().setStatus("Done");

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
            jsobject.setMember("console", k1mainapp.K1MainApp.getBridg());
            return true;
        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println(
                    "erorr in : " + getClass().getName()
                    + ", Message : " + ex.getMessage()
                    + ", method Name : " + name);
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
    }

    public void setProgressValue(double value) {
        ProgressBar bar = (ProgressBar) k1mainapp.K1MainApp.getStage().getScene().lookup("#prog");

        bar.setProgress((double) value);

        if ((double) value == 1.0) {
            bar.setProgress((double) 0);
        }

    }

    public void setScureURL(String URL) {
        try {
            we.load(URL);
            new JavaBridge().setStatus("Done");

        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }
    }

}
