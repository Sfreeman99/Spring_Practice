package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
public class ArraysAndLoopsController {
    @GetMapping("/lastThree")
    public List<Integer> lastThree(@RequestParam ArrayList<Integer> l){
        return l.subList(l.size() - 3, l.size());
    }
    @GetMapping("/sum")
    public double sum(@RequestParam ArrayList<Integer> l){
        double total = 0;
        for (int i = 0; i < l.size(); i++){
            total += l.get(i);
        }
        return total;
    }
    @GetMapping("/sumOfLonger")
    public double sumOfLonger(@RequestParam ArrayList<Integer> l1,@RequestParam ArrayList<Integer> l2){
        if (l1.size() > l2.size())
            return sum(l1);
        else if (l1.size() < l2.size())
            return sum(l2);
        else{
            return sum(l1) + ' ' + sum(l2);
        }
    }
    @GetMapping("/differenceFromMinimal")
    public ArrayList<Integer> differenceFromMinimal(@RequestParam ArrayList<Integer> l){
        int lowest = Collections.min(l);
        ArrayList a = new ArrayList();
        for (int i = 0; i < l.size(); i++){

            a.add(l.get(i) - l.get(lowest));

        }
        return a;
    }

    @GetMapping("/hashtagTweet")
    public String hashtagTweet(@RequestParam String tweet){
        String[] hashes = tweet.split(" ");
        String tags = "";
        for (int i = 0; i < hashes.length; i++){
            if (hashes[i].contains("#"))
                tags += hashes[i];
        }
        return tags;

    }
    @GetMapping("/mentions")
    public String mentions(@RequestParam String tweet){
        String[] hashes = tweet.split(" ");
        String mentions = "";
        for (int i = 0; i < hashes.length; i++){
            if (hashes[i].contains("@"))
                mentions += hashes[i];
        }
        return mentions;

    }
    @GetMapping("/parseInventory")
    public ArrayList parseInventory(@RequestParam String x){
        String[] inventory = x.split("\t");
        ArrayList product = new ArrayList();
        product.add(inventory[0]);
        product.add(Double.parseDouble(inventory[1]));
        product.add(Double.parseDouble(inventory[2]));
        return product;
    }
}
