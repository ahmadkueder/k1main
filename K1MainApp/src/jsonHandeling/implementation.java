package jsonHandeling;

import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ahmad
 */
public class implementation implements lib {

    static String stringFromJson = "";

    @Override
    public String returnJsonAsString(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            stringFromJson = everything;
            return everything;
        } catch (Exception e) {
            return "ERORR READING FILE";
        } finally {
            br.close();
        }
    }

    @Override
    public JSONArray getSpecificArray(String keyName) {
        try {
            JSONObject obj = new JSONObject(stringFromJson);
            return obj.getJSONArray(keyName);
        } catch (JSONException ex) {
            System.out.println("erorr Geting" + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getSpecificString(String keyName) {
        try {
            JSONObject obj = new JSONObject(stringFromJson);
            return obj.getString(keyName);
        } catch (JSONException ex) {
            System.out.println("erorr Geting" + ex.getMessage());
        }
        return null;
    }

    @Override
    public JSONObject getSpecificObject(String keyName) {
        try {
            JSONObject obj = new JSONObject(stringFromJson);
            return obj.getJSONObject(keyName);
        } catch (JSONException ex) {
            System.out.println("erorr Geting" + ex.getMessage());
        }
        return null;
    }

    @Override
    public int getSpecificInt(String keyName) {
        try {
            JSONObject obj = new JSONObject(stringFromJson);
            return obj.getInt(keyName);
        } catch (JSONException ex) {
            System.out.println("erorr Geting" + ex.getMessage());
        }
        return -1;
    }

    @Override
    public Double getSpecificDouble(String keyName) {
        try {
            JSONObject obj = new JSONObject(stringFromJson);
            return obj.getDouble(keyName);
        } catch (JSONException ex) {
            System.out.println("erorr Geting" + ex.getMessage());
        }
        return null;
    }

    @Override
    public Boolean getSpecificBoolean(String keyName) {
        try {
            JSONObject obj = new JSONObject(stringFromJson);
            return obj.getBoolean(keyName);
        } catch (JSONException ex) {
            System.out.println("erorr Geting" + ex.getMessage());
        }
        return null;
    }

}
