package com.Assignment.Service;

import com.Assignment.Entity.Product;
import com.Assignment.JsonData.ItemData;
import com.Assignment.JsonData.Json;
import com.Assignment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CalculatorService {

    @Autowired
    ProductRepository pr;

    public double cal(ItemData[] items) {
        double total = 0;
        for (ItemData item : items) {
            Optional<Product> p = pr.findById(item.id);
            Product pro = p.get();

            double item_price = pro.getPrice();
            int qty = item.qty;

            total = total + (item_price * qty);
        }

        return total;
    }
}
