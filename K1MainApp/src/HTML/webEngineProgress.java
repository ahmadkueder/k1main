package HTML;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ProgressBar;

public class webEngineProgress extends webManager implements ChangeListener<Number> {

    private static double parValue;

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        
        try {
            super.setProgressValue((double) newValue);
        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }
    }

;

}
