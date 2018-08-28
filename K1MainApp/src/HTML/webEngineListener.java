package HTML;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author ahmad
 *
 */
public class webEngineListener implements ChangeListener<Worker.State> {

    
    @Override
    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
        
        Stage st = k1mainapp.K1MainApp.getStage();
        javafx.scene.shape.Rectangle statusBar = (javafx.scene.shape.Rectangle) st.getScene().lookup("#boxColod");
        switch (newValue) {
            case SUCCEEDED:
                statusBar.setFill(Color.GREEN);
                System.out.println("SUCCEEDED");
                break;
            case READY:
                statusBar.setFill(Color.BLUE);
                break;
            case FAILED:
                statusBar.setFill(Color.RED);
                break;
            case CANCELLED:
                statusBar.setFill(Color.BLACK);
                break;
            case RUNNING:
                statusBar.setFill(Color.ORANGE);
                break;
            case SCHEDULED:
                statusBar.setFill(Color.ORANGE);
                break;
        }
      
    }

}
