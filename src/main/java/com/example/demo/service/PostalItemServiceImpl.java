package com.example.demo.service;

import com.example.demo.dto.PostalItemDto;
import com.example.demo.model.PostalItem;
import com.example.demo.repo.PostalItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostalItemServiceImpl implements PostalItemService {

    private PostalItemRepository postalItemRepository;

    @Autowired
    public PostalItemServiceImpl(PostalItemRepository postalItemRepository) {
        this.postalItemRepository = postalItemRepository;
    }

    @Override
    public void registerPostalItem(PostalItem postalItem) {
        postalItemRepository.save(postalItem);
    }

    @Override
    public PostalItem getEntityFromDto(PostalItemDto postalItemDto) {
        return null;
    }

    @Override
    public PostalItemDto getDtoFromEntity(PostalItem postalItem) {
        return new PostalItemDto(
                postalItem.getId(),
                postalItem.getPostalItemType(),
                postalItem.getPostalItemStatus(),
                postalItem.getNameReceiver(),
                postalItem.getTargetPostOffice().getIndex());
    }


}
