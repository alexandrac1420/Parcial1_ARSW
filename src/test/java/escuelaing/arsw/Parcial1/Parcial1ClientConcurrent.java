package escuelaing.arsw.Parcial1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Esta clase permite ejecutar pruebas concurrentes, donde se revisa que las pruebas sean concurrentes
 */

public class Parcial1ClientConcurrent {
    
    public static void main (String [] args){
        concurrentTest();
    }

    public static void concurrentTest(){
        final String USER_AGENT = "Mozilla/5.0";
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 1; i < 20; i++){
            executorService.execute(() -> {
                try{
                    URL obj = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo");
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("User-Agent", USER_AGENT);
                    
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
                        System.out.println("thread"+ Thread.currentThread().getId() + "Response" + response.toString());

                    }
                }catch(Exception e){
                    System.out.println("No existe informacion");

                }   
            });
    
        }
    }
}
