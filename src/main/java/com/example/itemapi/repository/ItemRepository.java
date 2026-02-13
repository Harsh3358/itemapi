package com.example.itemapi.repository;

import com.example.itemapi.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);

    Optional<Item> findById(Long id);

    List<Item> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);

}
