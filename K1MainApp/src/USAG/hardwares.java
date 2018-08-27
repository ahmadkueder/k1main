package USAG;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class hardwares {

    public String getCorrentMacAdress() {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < mac.length; i++) {
                
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                
            }

            return sb.toString();
        } catch (Exception ex) {
            String name = new Object() {
            }.getClass().getEnclosingMethod().getName();
            System.out.println(ex.getMessage() + " - " + getClass().getName() + " - " + name);
        }
        return "";
    }
}
