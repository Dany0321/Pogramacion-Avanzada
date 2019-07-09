
package tarjetas;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author javie
 */
public class Tarjetas {

    public static void send(String nombre) throws IOException {
        URL url = new URL("http://localhost/Cajero/Negociador.php");
        Map<String, Object> params = new LinkedHashMap<>();
 
        params.put("tarjeta", nombre);
 
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0)
                postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()),
                    "UTF-8"));
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
 
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length",
                String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);
 
        Reader in = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), "UTF-8"));
        for (int c = in.read(); c != -1; c = in.read())
            System.out.print((char) c);
    }
    
    public static void main(String[] args) {
        try {
            String nombre;
            Scanner s = new Scanner(System.in);
            System.out.println("Ingrese el numero de su tarjeta");
            nombre = s.nextLine();
            send(nombre);
        } catch (IOException ex) {
            Logger.getLogger(Tarjetas.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }
    
}
