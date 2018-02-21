package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ObjectController {
    @GetMapping("/readInventory")
    public HashMap<String, Item> getInventory(@RequestParam String inventory){
        if (inventory.equals("")){
            HashMap empty = new HashMap();
            return empty;
        }
        String[] splitOnNewLine = inventory.split("\n");
        HashMap<String, Item> entry = new HashMap();
        for (int i = 0; i < splitOnNewLine.length; i++){
            String[] splitOnNewTab = splitOnNewLine[i].split("\t");
            String productName = splitOnNewTab[0];
            double paid = Double.parseDouble(splitOnNewTab[1]);
            double charging = Double.parseDouble(splitOnNewTab[2]);
            Item items = new Item(productName, paid, charging);
            entry.put(productName, items);
        }
        return entry;

    }

    @GetMapping("/dollarStore")
    public boolean dollarStore(@RequestParam HashMap inventory){
        return inventory.containsKey("price");
    }

}
