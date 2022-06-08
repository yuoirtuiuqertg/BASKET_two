package com.example.baskett.controllers;

import com.example.baskett.models.Basket;
import com.example.baskett.services.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/JSON", produces="application/json")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

   /* @GetMapping("/basket")
    public List<Basket> get (){
        List<Basket> product = basketService.listBasketALL();
        return product;
    }*/

    /*@GetMapping  (value = "/{title}/{name}/{price}/{count}")
    public List<Basket> putBasket(@PathVariable("title") String title,
                                  @PathVariable("name") String name,
                                  @PathVariable("price") int price,
                                  @PathVariable("count") int count){
        Basket basket = new Basket();
        basket.setTitle(title);
        basket.setName(name);
        basket.setPrice(price);
        basket.setCount(count);
        basketService.saveBasket(basket);
        List<Basket> product = basketService.listBasketALL();
        return product;
    }*/

    //curl -X POST -H "Content-type: application/json" -d "{\"title\" : \"milk\", \"name\" : \"mmm\",\"price\" : \"192\" , \"count\":\"93\" }" "http://localhost:8080/JSON/create"
    @PostMapping  (value = "/create",consumes = "application/json", produces = "application/json")
    public List<Basket> createBasket(@RequestBody Basket basket){
        basketService.saveBasket(basket);
        List<Basket> product = basketService.listBasketALL();
        return product;
    }
    /*@GetMapping("/delete/{id}")
    public List<Basket>  deleteById(@PathVariable Long id){
        basketService.deleteBasket(id);
        List<Basket> product = basketService.listBasketALL();
        return product;
    }*/

    @DeleteMapping(path = "/{id}")
    public List<Basket>  deleteBy (@PathVariable Long id){
        basketService.deleteBasket(id);
        List<Basket> product = basketService.listBasketALL();
        return product;
    }

    @DeleteMapping(path = "/all")
    public List<Basket>  deleteAllBasket (){
        basketService.deleteAllBasket();
        List<Basket> product = basketService.listBasketALL();
        return product;
    }
    /*@GetMapping("/delete/all")
    public List<Basket>  deleteAll(){
        basketService.deleteAllBasket();
        List<Basket> product = basketService.listBasketALL();
        return product;
    }*/




}
