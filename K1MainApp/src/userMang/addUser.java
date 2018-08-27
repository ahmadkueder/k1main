package userMang;

import javafx.scene.web.WebView;
import javafx.stage.Stage;
import HTML.webEngineManager;

/**
 *
 * @author ahmad
 */
public class addUser {

    /**
     *
     * @param FromName
     */
    public void addUserForm(String FromName) {


        Stage st = k1mainapp.K1MainApp.getStage();

        WebView center = (WebView) st.getScene().lookup("#center");
        try {
            
            webEngineManager mang = new webEngineManager();
            mang.initEngine(center, FromName);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
