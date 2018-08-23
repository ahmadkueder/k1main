package jsonHandeling;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ahmad
 */
public interface lib {

    public String returnJsonAsString(String fileName) throws Exception;

    public String getSpecificString(String keyName);

    public JSONObject getSpecificObject(String keyName);
    
    public JSONArray getSpecificArray(String keyName);

    public int getSpecificInt(String keyName);

    public Double getSpecificDouble(String keyName);

    public Boolean getSpecificBoolean(String keyName);
}
