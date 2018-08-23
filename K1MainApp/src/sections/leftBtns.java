package sections;

import USAG.propsHandel;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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
            System.out.println(jsonContent);
            JSONArray btn_ = lib.getSpecificObject("leftSectionItems").getJSONObject(invokeSection).getJSONArray("items");
            Button btn;
            Node[] btnsNode = new Node[btn_.length()];
            
            for (int i = 0; i < btn_.length(); i++) {
                JSONObject btnObj = (JSONObject) btn_.get(i);
                
                btn = new Button(btnObj.getString("name"));
                
                FontAwesomeIconView FontAwesomeIconView = new FontAwesomeIconView(FontAwesomeIcon.valueOf(btnObj.getString("icon")));
                
                FontAwesomeIconView.setFill(Color.SNOW);
                
                FontAwesomeIconView.glyphStyleProperty().setValue("-fx-background-color: red;");
                
  
                
                FontAwesomeIconView.getStyleClass().add("sexy");
                
                btn.setId(btnObj.getString("id"));
                
                btn.getStyleClass().add("leftBtns");
                
                btn.setGraphic(FontAwesomeIconView);
                
                btnsNode[i] = btn;
            }
            
            btnContainer.getChildren().addAll(btnsNode);
            
        } catch (Exception ex) {
            System.out.println("erorr handeling jsonfile : " + ex.getMessage() + "className " + this.getClass().getName());
        }
        
        return btnContainer;
    }
    
}
