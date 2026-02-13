package com.example.itemapi.service;

import com.example.itemapi.dto.ItemRequest;
import com.example.itemapi.dto.ItemResponse;
import com.example.itemapi.model.Item;
import com.example.itemapi.repository.ItemRepository;
import com.example.itemapi.util.IdGenerator;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    private final IdGenerator idGenerator;

    public ItemServiceImpl(ItemRepository repository, IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    @Override
    public ItemResponse addItem(ItemRequest request) {

        Item item = new Item();

        item.setId(idGenerator.nextId());
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setPrice(request.getPrice());
        item.setCategory(request.getCategory());

        Instant now = Instant.now();

        item.setCreatedAt(now);
        item.setUpdatedAt(now);

        repository.save(item);

        return mapToResponse(item);
    }

    //Find in repository --> convert to Response DTO --> return
    @Override
    public ItemResponse getItemById(Long id) {

        Item item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));

        return mapToResponse(item);
    }

    // Converts internal model to API response
    private ItemResponse mapToResponse(Item item) {

        return new ItemResponse(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getCategory(),
                item.getCreatedAt()
        );
    }
}
