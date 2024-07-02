package escuelaing.arsw.Parcial1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta clase se encarga de manejar las solicitudes http realizadas desde el html.
 */

@RestController
public class Parcial1Controller {
    private ArrayList<String> cache = new ArrayList();

    @Autowired
    private Parcial1Service parcial1Service;

    @RequestMapping(
            value = "/getvalue",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public String getValueBag(@RequestParam String function, @RequestParam String symbol, @RequestParam (required = false) String interval){
        String response = parcial1Service.getValueApi(function, symbol, interval);
        if(cache.contains(response)){
            return cache.get(cache.indexOf(response));
        }else{
            cache.add(0, response);
            return response;
    }
        }
}
