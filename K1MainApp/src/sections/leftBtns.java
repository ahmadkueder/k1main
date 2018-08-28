package sections;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import static java.lang.Class.forName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import jsonHandeling.implementation;
import jsonHandeling.lib;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ahmad
 */
public class leftBtns {

    /**
     *
     * @param invokeSection
     * @return
     */
    public VBox printLeftSectionBtns(String invokeSection) {

        VBox btnContainer = new VBox();

        btnContainer.styleProperty().setValue("-fx-background: red; ");
        btnContainer.paddingProperty().setValue(new Insets(5));
        btnContainer.spacingProperty().setValue(5);
        btnContainer.alignmentProperty().setValue(Pos.TOP_CENTER);

        lib lib = new implementation();

        try {

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
                
                
                Object clas  = forName(invokeSection + "." + btn.getId()).newInstance();
                
                btn.setOnAction((EventHandler<ActionEvent>) clas);
                
//                Constructor consr = clas.getDeclaredConstructor(new Class[]{Button.class});
//                consr.newInstance(new Object[]{btn});
                
                
                btn.setTooltip(new Tooltip(btnObj.getString("hint")));
                btn.setGraphic(FontAwesomeIconView);

                
                btnsNode[i] = btn;
            }

            btnContainer.getChildren().addAll(btnsNode);

        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println("erorr in : " + getClass().getName() + ", Message : " + ex.getMessage() + ", method Name : " + name);
        }

        return btnContainer;
    }

}
