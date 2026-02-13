package com.example.itemapi.service;

import com.example.itemapi.dto.ItemRequest;
import com.example.itemapi.dto.ItemResponse;

public interface ItemService {

    ItemResponse addItem(ItemRequest request);

    ItemResponse getItemById(Long id);

    ItemResponse updateItem(Long id, ItemRequest request);

    void deleteItem(Long id);

}
