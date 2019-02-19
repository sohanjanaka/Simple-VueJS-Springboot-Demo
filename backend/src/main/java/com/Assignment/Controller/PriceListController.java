package com.Assignment.Controller;

import com.Assignment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PriceListController {

    @RequestMapping("/")
    String priceList (){
        return "index";
    }

    @RequestMapping("/test")
    String test (){
        return "test";
    }

    @Autowired
    ProductRepository pr;
}
