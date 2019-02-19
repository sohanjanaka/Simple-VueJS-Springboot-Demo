package com.Assignment.JsonData;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
@Setter
public class Json {
    @Override
    public String toString() {
        return "Json{" +
                "productJson=" + Arrays.toString(productJson) +
                '}';
    }

    public ItemData[] getProductJson() {
        return productJson;
    }

    ItemData[] productJson;
}
