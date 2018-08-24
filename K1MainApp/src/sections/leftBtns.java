package sections;

import USAG.propsHandel;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import jsonHandeling.implementation;
import jsonHandeling.lib;
import org.json.JSONArray;
import org.json.JSONObject;

public class leftBtns {

    public VBox printLeftSectionBtns(String invokeSection) {

        VBox btnContainer = new VBox();

        btnContainer.styleProperty().setValue("-fx-background: red; ");
        btnContainer.paddingProperty().setValue(new Insets(10));
        btnContainer.spacingProperty().setValue(5);
        btnContainer.alignmentProperty().setValue(Pos.TOP_CENTER);

        lib lib = new implementation();

        try {

            String jsonContent = lib.returnJsonAsString(propsHandel.getProp("jsonFilePath"));

            JSONArray btn_ = lib.getSpecificObject("leftSectionItems").getJSONObject(invokeSection).getJSONArray("items");
            Button btn;
            Node[] btnsNode = new Node[btn_.length()];

            for (int i = 0; i < btn_.length(); i++) {

                JSONObject btnObj = (JSONObject) btn_.get(i);

                String btnFunction = btnObj.getString("listinerName");
                

                btn = new Button(btnObj.getString("name"));

                FontAwesomeIconView FontAwesomeIconView = new FontAwesomeIconView(FontAwesomeIcon.valueOf(btnObj.getString("icon")));

                FontAwesomeIconView.setFill(Color.SNOW);

                btn.setId(btnObj.getString("id"));

                btn.getStyleClass().add("leftBtns");

                btn.setGraphic(FontAwesomeIconView);

                this.setAction(btn, invokeSection, btnFunction);

                btnsNode[i] = btn;
            }

            btnContainer.getChildren().addAll(btnsNode);

        } catch (Exception ex) {
            System.out.println("erorr handeling jsonfile : " + ex.getMessage() + "className " + this.getClass().getName());
        }

        return btnContainer;
    }

    /**
     * @param btn Button
     * @param invokeSection string
     * @param functionName
     *
     */
    public void setAction(Button btn, String invokeSection, String functionName) {
        btn.setOnAction(event -> {
            Class clas;

            try {
                clas = Class.forName(invokeSection + "." + btn.getId());

                Object obj = clas.newInstance();
                System.out.println(functionName);
                Method meth = clas.getDeclaredMethod(functionName, String.class);

                meth.invoke(obj, btn.getId());

                //Method methods = clas.getDeclaredMethod(btn.getId());
                //methods.invoke(instense, btn.getId());
            } catch (ClassNotFoundException e) {
                System.out.println("erorr : " + e + " Class Name : " + this.getClass().getName());
            } catch (InstantiationException e) {
                System.out.println("erorr : " + e + " Class Name : " + this.getClass().getName());
            } catch (IllegalAccessException e) {
                System.out.println("erorr : " + e + " Class Name : " + this.getClass().getName());
            } catch (NoSuchMethodException e) {
                System.out.println("erorr : " + e + " Class Name : " + this.getClass().getName());
            } catch (SecurityException e) {
                System.out.println("erorr : " + e + " Class Name : " + this.getClass().getName());
            } catch (IllegalArgumentException e) {
                System.out.println("erorr : " + e + " Class Name : " + this.getClass().getName());
            } catch (InvocationTargetException e) {
                System.out.println("erorr : " + e + " Class Name : " + this.getClass().getName());
            }
        });

    }

}
