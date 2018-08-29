package HTML;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.paint.Color;

public class webEngineListener extends webManager implements ChangeListener<Worker.State> {


    private static boolean ISdone;

    @Override
    public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {

        try {

            switch (newValue) {
                case SUCCEEDED:
                    super.setStatusBoxColor(Color.GREEN.toString());
                    new webManager().setJSobjectName("window");
                    break;
                case READY:
                    super.setStatusBoxColor(Color.BLUE.toString());
                    break;
                case FAILED:
                    super.setStatusBoxColor(Color.RED.toString());
                    break;
                case CANCELLED:
                    super.setStatusBoxColor(Color.BLACK.toString());
                    break;
                case RUNNING:
                    super.setStatusBoxColor(Color.ORANGE.toString());

                    break;
                case SCHEDULED:
                    super.setStatusBoxColor(Color.ORANGE.toString());
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




}
