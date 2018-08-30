package HTML;

import USAG.*;
import java.net.URL;
import java.net.URLConnection;

public class internet {

    private static  boolean isConnect;

    public internet(URLConnection con) {
        try {
            URL url = new URL(new propsHandel().getProp("APIlink"));
            con = url.openConnection();
            con.connect();
            internet.isConnect = true;
        } catch (Exception ex) {
            internet.isConnect = false;
        }
    }

    public  boolean isConnect() {
        return true;
    }

    /**
     * ************
     */
    public  boolean isIsConnect() {
        return isConnect;
    }

}
