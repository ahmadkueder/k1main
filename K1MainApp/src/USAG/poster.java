package USAG;

import static USAG.propsHandel.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import HTML.*;

/**
 *
 * @author ahmad
 */
public final class poster {

    // GET OR POST
    /**
     *
     */
    private String methodType;
    // JSON stringfyed Object

    /**
     *
     */
    private String toPass;
    // if the data are sent to server

    /**
     *
     */
    private boolean isDone;
    // init soon

    /**
     *
     */
    private String keyDataToGet;
    // besice connection

    /**
     *
     */
    HttpURLConnection con;
    // the connection status

    /**
     *
     */
    private String connectionStatus;
    // to store the server request

    /**
     *
     */
    private String serverResponce;

    // get main object Key 
    /**
     *
     */
    private String getMainKey;

    /**
     *
     */
    public poster() {
    }

    internet internet;

    /**
     * @param type
     * @param topass
     *
     */
    public poster(String type, String topass) {

        try {
            switch (type) {
                case "GET":
                    this.setToPass(topass);
                    this.methodType = type;
                    this.setKeyDataToGet(topass);
                    this.setGetMainKey(new JSONObject(this.getToPass()).getString("key"));
                    getMethod();
                    break;
                case "POST":
                    this.setToPass(topass);
                    this.methodType = type;
                    this.setGetMainKey(new JSONObject(this.getToPass()).getString("key"));
                    postMehto();
                    break;
            }
        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println(ex.getMessage() + " - " + getClass().getName() + " - " + name);
        }
    }

    /**
     * init GET request Method
     *
     */
    private void getMethod() {
        String dataToPass = this.encodeJsonObject();

        if (new internet(con).isIsConnect()) {
            try {

                URL url = new URL(new propsHandel().getProp("APIlink") + "?" + dataToPass);

                con = (HttpURLConnection) url.openConnection();

                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");
                hardwares hard = new hardwares();
                con.setRequestProperty("User-Agent", new JSONObject().put("MAC", hard.getCorrentMacAdress()).toString());

                con.setDoOutput(true);

                int contentLength = con.getContentLength();

                

                InputStream inpput = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inpput));

                String line = null;
                StringBuilder buld = new StringBuilder();

                while ((line = br.readLine()) != null) {

                    buld.append(line);
                }

                switch (con.getResponseCode()) {
                    case 200:
                        setConnectionStatus("CONNECTED");
                        setserverResponce(buld.toString());
                        setIsDone(true);
                        break;
                    case 404:
                        setIsDone(false);
                        setConnectionStatus("NOT FOUND");
                        setserverResponce(null);
                        break;
                    default:
                        setConnectionStatus("Connection Code Is : " + con.getResponseCode());
                        setIsDone(false);
                }

            } catch (Exception ex) {
                String name = new Object() {
                }.getClass().getEnclosingMethod().getName();
                System.out.println(ex.getMessage() + " - " + getClass().getName() + " - " + name);
            } finally {
                con.disconnect();
            }
        } else {
            new JavaBridge().setRectangeColor("RED");
            new JavaBridge().setStatus("No internet Connection");
        }
    }

    /**
     * init POST request Method
     *
     */
    private void postMehto() {
        String dataToPass = this.encodeJsonObject();
        byte[] converByte = dataToPass.getBytes();
        if (new internet(con).isIsConnect()) {
            
            try {
                con = (HttpURLConnection) new URL(new propsHandel().getProp("APIlink")).openConnection();
                con.setDoOutput(true);
                con.setRequestMethod(methodType);
                con.setRequestMethod(this.getMethodType());
                hardwares hard = new hardwares();

                con.setRequestProperty("User-Agent", new JSONObject()
                        .put("MAC", hard.getCorrentMacAdress())
                        .toString());

                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                DataOutputStream out = new DataOutputStream(con.getOutputStream());
                out.write(converByte);

                InputStream input = con.getInputStream();
                InputStreamReader reader = new InputStreamReader(input);
                BufferedReader breader = new BufferedReader(reader);
                StringBuilder builder = new StringBuilder();

                String line;
                while ((line = breader.readLine()) != null) {
                    builder.append(line).append("\n");
                }

                switch (con.getResponseCode()) {
                    case 200:
                        this.setServerResponce(builder.toString());
                        this.setConnectionStatus("Connected");
                        this.setserverResponce(builder.toString());
                        this.setIsDone(true);
                        break;
                    case 404:
                        this.setServerResponce(builder.toString());
                        this.setConnectionStatus("NOT FOUND");
                        this.setserverResponce(builder.toString());
                        this.setIsDone(false);
                        break;
                    default:
                }

            } catch (Exception ex) {
                String name = new Object() {
                }.getClass().getEnclosingMethod().getName();
                System.out.println(ex.getMessage() + " - " + getClass().getName() + " - " + name);
                System.out.println(ex.getMessage() + " - " + getClass().getName() + " - ");

            }
        } else {
            
            new JavaBridge().setRectangeColor("RED");
            new JavaBridge().setStatus("No internet Connection");
        }
    }

    /**
     * *
     * to return the data as string to pass them into post or get
     *
     * @return
     */
    private String encodeJsonObject() {

        try {
            String dataToPass = this.getToPass();
            String mainKey = this.getGetMainKey();

            Map<String, String> mapToas = new HashMap<>();
            JSONObject obje = new JSONObject(dataToPass).getJSONObject("data");
            mapToas.put(mainKey, obje.toString());

            return this.getParamsString(mapToas);
        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println(ex.getMessage() + " - " + getClass().getName() + " - " + name);
        }
        return "";
    }

    /**
     *
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

    /**
     * ** geter and setter
     *
     * @param toPass
     */
    public void setToPass(String toPass) {
        this.toPass = toPass;
    }

    /**
     *
     * @return
     */
    public String getToPass() {
        return toPass;
    }

    /**
     *
     * @return
     */
    public boolean isDone() {
        return this.isIsDone();
    }

    /**
     *
     * @return
     */
    public boolean isIsDone() {
        return isDone;
    }

    /**
     *
     * @return
     */
    public String getMethodType() {
        return methodType;
    }

    /**
     *
     * @param methodType
     */
    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    /**
     *
     * @return
     */
    public String getKeyDataToGet() {
        return keyDataToGet;
    }

    /**
     *
     * @param keyDataToGet
     */
    public void setKeyDataToGet(String keyDataToGet) {
        this.keyDataToGet = keyDataToGet;
    }

    /**
     *
     * @return
     */
    public HttpURLConnection getCon() {
        return con;
    }

    /**
     *
     * @param con
     */
    public void setCon(HttpURLConnection con) {
        this.con = con;
    }

    /**
     *
     * @param isDone
     */
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     *
     * @return
     */
    public String getConnectionStatus() {
        return connectionStatus;
    }

    /**
     *
     * @param connectionStatus
     */
    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    /**
     *
     * @return
     */
    public String getserverResponce() {
        return serverResponce;
    }

    /**
     *
     * @param connectionResponce
     */
    public void setserverResponce(String connectionResponce) {
        this.serverResponce = connectionResponce;
    }

    /**
     *
     * @return
     */
    public String getServerResponce() {
        return serverResponce;
    }

    /**
     *
     * @param serverResponce
     */
    public void setServerResponce(String serverResponce) {
        this.serverResponce = serverResponce;
    }

    /**
     *
     * @return
     */
    public String getGetMainKey() {
        return getMainKey;
    }

    /**
     *
     * @param getMainKey
     */
    public void setGetMainKey(String getMainKey) {
        this.getMainKey = getMainKey;
    }
}
