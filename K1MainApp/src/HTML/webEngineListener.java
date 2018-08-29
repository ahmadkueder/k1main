package HTML;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class webEngineListener implements ChangeListener<Worker.State> {

    private String status;
    private static boolean ISdone;

    @Override
    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
        Stage st = k1mainapp.K1MainApp.getStage();
        javafx.scene.shape.Rectangle statusBar = (javafx.scene.shape.Rectangle) st.getScene().lookup("#boxColod");
        try {

            switch (newValue) {
                case SUCCEEDED:
                    statusBar.setFill(Color.GREEN);
                    new webManager().setJSobjectName("window");
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

        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }

    }

    public static boolean isISdone() {
        return ISdone;
    }

    public static void setISdone(boolean ISdone) {
        webEngineListener.ISdone = ISdone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }

}
