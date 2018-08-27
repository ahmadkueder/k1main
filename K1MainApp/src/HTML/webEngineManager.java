package HTML;

import java.net.URL;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import netscape.javascript.JSObject;
import org.w3c.dom.Document;

/**
 *
 * @author ahmad
 */
public class webEngineManager {

    /**
     * @param webView
     * @param pageName
     * @return
     *
     */
    public WebEngine initEngine(WebView webView, String pageName) {
        /**
         *
         */
        Stage st = k1mainapp.K1MainApp.getStage();

        /**
         *
         */
        Text statusBar = (Text) st.getScene().lookup("#statusBar");
        
        webView.setContextMenuEnabled(false);
        WebEngine webEngine = webView.getEngine();

        try {

            webEngine.setJavaScriptEnabled(true);

            URL url = new URL(getClass().getResource(pageName + ".html").toString());

            webEngine.onAlertProperty().setValue((odl) -> {
                statusBar.setText(odl.getData());
            });

            webEngine.onErrorProperty().setValue(v -> {
                statusBar.setText(v.getMessage());
            });

            webEngine.load(url.toURI().toURL().toExternalForm());
            webEngine.getLoadWorker().stateProperty().addListener(
                    (ObservableValue<? extends State> observable, State oldValue, State newValue) -> {
                        System.out.println("observable : " + observable);
                        System.out.println("oldValue :" + oldValue);
                        System.out.println("newValue : " + newValue);
                        try {

                            if (null != newValue) {
                                switch (newValue) {
                                    case SUCCEEDED:
                                        st.setTitle(pageName);
                                        JSObject window = (JSObject) webEngine.executeScript("window");
                                        window.setMember("java", new JavaBridge());
                                        JSObject doc = (JSObject) webEngine.getDocument();
                                        break;
                                    case SCHEDULED:
                                        System.out.println("-----SCHEDULED------");
                                        break;
                                    case RUNNING:
                                        System.out.println("------RUNNING-----");
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } catch (Exception e) {
                            String name = new Object() {
                            }.getClass().getEnclosingMethod().getName();
                            System.out.println(e.getMessage() + " - " + getClass().getName() + " - " + name);
                        }

                    });

            return webEngine;
        } catch (Exception e) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println(e.getMessage() + " - " + getClass().getName() + " - " + name);
        }

        return webEngine;
    }
    
    


}
