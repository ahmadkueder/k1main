package sections;

import static USAG.propsHandel.getProp;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.HBox;
import jsonHandeling.implementation;
import jsonHandeling.lib;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class topBtns {

    HBox hbox;
    lib jsonHand;
    final String JSONfilePath = getProp("jsonFilePath");

    public HBox printTopElements() {

        // init container
        hbox = new HBox();
        hbox.setSpacing(5);
        hbox.paddingProperty().set(new Insets(10));
        hbox.setMaxHeight(Double.MAX_EXPONENT);
        hbox.idProperty().setValue("topHbox");

        // int contents
        JSONArray btns = this.returnBtnsObjects();
        Node[] btnsNodes = new Node[btns.length()];
        final Class[] args = new Class[btns.length()];
        for (int i = 0; i < btns.length(); i++) {
            Button btn_ = new Button();
            try {

                JSONObject btn = btns.getJSONObject(i);
                String btnName = btn.getString("name");
                String btnID = btn.getString("id");
                String btnListenerName = btn.getString("listenerName");
                String btnIcon = btn.getString("icon");

                btn_.setText(btnName);

                btn_.setId(btnID);
                btn_.setPrefHeight(50);

                btn_.contentDisplayProperty().setValue(ContentDisplay.TOP);

                FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.valueOf(btnIcon));

                btn_.setGraphic(icon);

                btn_.setOnAction((ActionEvent event) -> {
                    //load the AppTest at runtime
                    Class cls;
                    try {
                        cls = Class.forName("sections.topBtnsFunctions");
                        Object obj = cls.newInstance();

                        //call the printIt method
                        Method method = cls.getDeclaredMethod(btnListenerName, Button.class);
                        method.invoke(obj, btn_);

                    } catch (ClassNotFoundException ex) {
                        System.err.println("ClassNotFoundException :" + this.getClass().getName() + " --Erorr Type : " + ex.getMessage());
                    } catch (InstantiationException ex) {
                        System.err.println("InstantiationException " + this.getClass().getName() + " --Erorr Type : " + ex.getMessage());
                    } catch (IllegalAccessException ex) {
                        System.err.println("IllegalAccessException " + this.getClass().getName() + " --Erorr Type : " + ex.getMessage());
                    } catch (IllegalArgumentException ex) {
                        System.err.println("IllegalArgumentException " + this.getClass().getName() + " --Erorr Type : " + ex.getMessage());
                    } catch (InvocationTargetException ex) {
                        System.err.println("InvocationTargetException " + this.getClass().getName() + " --Erorr Type : " + ex.getMessage());
                    } catch (NoSuchMethodException ex) {
                        System.err.println("NoSuchMethodException " + this.getClass().getName() + " --Erorr Type : " + ex.getMessage());
                    } catch (SecurityException ex) {
                        System.err.println("SecurityException " + this.getClass().getName() + " --Erorr Type : " + ex.getMessage());
                    }
                });

                btnsNodes[i] = btn_;
            } catch (JSONException ex) {
                System.out.println("could not import JSON object from jsonarray  : " + ex.getMessage());
            }
        }

        hbox.getChildren().addAll(btnsNodes);
        return hbox;
    }

    // fetch Btns names from Stroktur file
    public JSONArray returnBtnsObjects() {
        jsonHand = new implementation();
        JSONArray returned = null;
        try {
            jsonHand.returnJsonAsString(JSONfilePath);
            JSONObject mainScenItems = jsonHand.getSpecificObject("mainSceneItems");
            JSONArray btns = mainScenItems.getJSONArray("Buttons");
            returned = btns;
        } catch (Exception ex) {
            System.out.println("erorr read JSON file path - Class Name : "  + getClass().getName() + ex.getMessage());
        }

        return returned;
    }

}
