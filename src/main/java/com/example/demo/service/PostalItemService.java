package com.example.demo.service;

import com.example.demo.dto.PostalItemDto;
import com.example.demo.model.PostalItem;

public interface PostalItemService {
    void registerPostalItem(PostalItem postalItem);
    PostalItem getEntityFromDto(PostalItemDto postalItemDto);
    PostalItemDto getDtoFromEntity(PostalItem postalItem);
}
