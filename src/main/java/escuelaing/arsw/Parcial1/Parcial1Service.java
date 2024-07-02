package escuelaing.arsw.Parcial1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
/**
 * Esta clase contiene la logica en la que reaiza una conexion a la API alphavantage
 */
@Service
public class Parcial1Service implements Api_Interface{
    private static final String KEY = "demo";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://www.alphavantage.co/query?";

 
    public String getValueApi(String function, String symbol, String interval) {
        try{
            URL obj = new URL(GET_URL+"function=" +function + "&symbol=" + symbol + ((interval != "") ? "&interval=" + interval : "") + "&apikey=" + KEY);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            String responseFinal = "";
            
            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
                responseFinal = response.toString();
                
            } else {
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
            System.out.println(obj.toString());
            return responseFinal;
        }catch(Exception e){
            return "No existe informacion";
        }
    }
    
}

