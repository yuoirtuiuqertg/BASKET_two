package com.example.baskett.repositories;

import com.example.baskett.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepositorie extends JpaRepository<Basket , Long> {
    List<Basket> findByName(String name);
}
