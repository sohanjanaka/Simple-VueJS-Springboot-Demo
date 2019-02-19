package com.Assignment.JsonData;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;

@Getter
@Setter
public class ItemData {

    @Id
    public int id;
    public String name;
    public int qty;

    public ItemData(){}

    @Override
    public String toString() {
        return "ItemData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                '}';
    }



}
