package com.example.demo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SpoonaSreachController {
    String url = "https://api.spoonacular.com/recipes/findByIngredients";
    String apikey = "?apiKey=21b6a1afab9646f7a125f7ba0331f024";

    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
    //to make pull
    // search formula http://localhost:8080/byingredient&ingredients="meat"
    @GetMapping("/byingredient")
    public String listOfRecipes(@RequestParam(value = "ingredients") String ingredients) {
        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        String response = restTemplate.getForObject(url + apikey + "&" + "ingredients=" + ingredients + "&number=2", String.class);
        return "{ 'content':'" + response + "'}";
    }
}
