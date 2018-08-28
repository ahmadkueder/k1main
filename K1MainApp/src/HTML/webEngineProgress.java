package HTML;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ProgressBar;

public class webEngineProgress implements ChangeListener<Number> {

    private static double parValue;

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        try {
            ProgressBar bar = (ProgressBar) k1mainapp.K1MainApp.getStage().getScene().lookup("#prog");
            bar.setProgress((double) newValue);

        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }
    }

;

}
