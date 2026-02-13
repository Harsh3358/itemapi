package com.example.itemapi.repository;

import com.example.itemapi.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class InMemoryItemRepository implements ItemRepository {

    private final ConcurrentMap<Long, Item> storage = new ConcurrentHashMap<>();

    @Override
    public Item save(Item item) {

        storage.put(item.getId(), item);

        return item;
    }

    @Override
    public Optional<Item> findById(Long id) {

        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Item> findAll() {

        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }
}
