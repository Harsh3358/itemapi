package com.example.itemapi.controller;

import com.example.itemapi.dto.ItemRequest;
import com.example.itemapi.dto.ItemResponse;
import com.example.itemapi.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // POST /api/items
    @PostMapping
    public ResponseEntity<ItemResponse> addItem(@RequestBody ItemRequest request) {

        ItemResponse response = itemService.addItem(request);

        return ResponseEntity
                .created(URI.create("/api/items/" + response.getId()))
                .body(response);
    }

    // GET /api/items/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getItemById(@PathVariable Long id) {

        ItemResponse response = itemService.getItemById(id);

        return ResponseEntity.ok(response);
    }
}
