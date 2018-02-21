package com.example.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicsController {
    @GetMapping("/add")
    public int add(@RequestParam int x,@RequestParam int y){
        return x + y;
    }
    @GetMapping("/double")
    public int Double(@RequestParam int x){
        return x * 2;
    }
    @GetMapping("/multiThree")
    public int multiThree(@RequestParam int a, @RequestParam int b, @RequestParam int c){
        return ((a * 15) + (b * 12) + (c * 9));
    }
    @GetMapping("/both")
    public boolean both(@RequestParam boolean x, @RequestParam boolean y){
        if (x == true && y == true){
            return true;
        } else
            return false;
    }
    @GetMapping("/walkOrDrive")
    public String walkOrDrive(@RequestParam int miles, @RequestParam boolean isNiceWeather) {
        if (miles < .25 && isNiceWeather == true)
            return "walk";
        else
            return "drive";
    }
    @GetMapping("/howPopulated")
    public String howPopulated(@RequestParam double population, @RequestParam double landArea){
        double populationDensity = population / landArea;
        if (populationDensity > 100)
            return "Densely Populated";
        else
            return "Sparsely Populated";
    }
    @GetMapping("/goldStars")
    public String goldStars(@RequestParam int points){

        if (1000 > points && points < 5000)
            return "**";
        else if (points >= 5000 && points < 8000)
            return "***";
        else if (points >= 8000 && points < 10000)
            return "****";
        else if (points >= 10000)
            return "*****";
        else
            return "*";

    }
    @GetMapping("/howManyPoints")
    public int howManyPoints(@RequestParam String scoringAction){
        int score;
        switch (scoringAction){
            case "extra point kick":
                score = 1;
                break;
            case "extra point conversion":
                score = 2;
                break;
            case "safety":
                score = 2;
                break;
            case "field goal":
                score = 3;
                break;
            case "touchdown":
                score = 6;
                break;
            default:
                score = 0;
                break;

        }
        return score;
    }

}
