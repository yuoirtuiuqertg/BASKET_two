package com.example.baskett.services;

import com.example.baskett.models.Basket;
import com.example.baskett.repositories.BasketRepositorie;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class BasketService {
    private final BasketRepositorie basketRepositories;

    public List<Basket> listBasket(String title) {
        List<Basket> products = basketRepositories.findAll();
        if(title != null) basketRepositories.findByName(title);
        return products;
    }
    public List<Basket> listBasketALL() {
        List<Basket> products = basketRepositories.findAll();
        return products;
    }


    public void saveBasket(Basket product) {
        log.info("Saving ne {}",product);
        basketRepositories.save(product);
    }

    public void deleteBasket(Long id) {
        basketRepositories.deleteById(id);
    }

    public void deleteAllBasket() {
        basketRepositories.deleteAll();
    }

}
