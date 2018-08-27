package userMang;

import HTML.webEngineManager;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class existingUser {

    public void existingUserForm(String formName) {
        String FormNAme;

        Stage st = k1mainapp.K1MainApp.getStage();

        WebView center = (WebView) st.getScene().lookup("#center");
        try {
            webEngineManager mang = new webEngineManager();
            mang.initEngine(center, formName);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
