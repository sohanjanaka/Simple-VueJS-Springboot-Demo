package com.Assignment.Controller;

import com.Assignment.JsonData.ItemData;
import com.Assignment.JsonData.Json;
import com.Assignment.Service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class CalculatorRestController {

    @Autowired
    CalculatorService calService;

    @RequestMapping(method = RequestMethod.POST, value = "/cal")
    double calculate (@RequestBody ItemData[] json){
        return calService.cal(json);
    }
}
