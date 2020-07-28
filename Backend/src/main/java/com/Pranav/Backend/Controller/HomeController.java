package com.Pranav.Backend.Controller;


import com.Pranav.Backend.Model.StateData;
import com.Pranav.Backend.Service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private CovidDataService covidDataService;

    @PostMapping("/saveData")
    public List<StateData> save() throws IOException
    {
    return     covidDataService.saveData();
    }

@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getData")
   public List<Map<String,Object>> get()
    {
        return covidDataService.getData();
    }
}
