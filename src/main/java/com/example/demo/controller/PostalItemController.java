package com.example.demo.controller;

import com.example.demo.dto.PostalItemDto;
import com.example.demo.dto.PostalItemRegistrationDto;
import com.example.demo.model.PostOffice;
import com.example.demo.model.PostalItem;
import com.example.demo.model.PostalItemStatus;
import com.example.demo.repo.PostOfficeRepository;
import com.example.demo.repo.PostalItemRepository;
import com.example.demo.service.PostalItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PostalItemController {

    private PostalItemService postalItemService;

    private PostalItemRepository postalItemRepository;

    private PostOfficeRepository postOfficeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public PostalItemController(PostalItemRepository postalItemRepository,
                                PostalItemService postalItemService,
                                PostOfficeRepository postOfficeRepository) {

        this.postalItemRepository = postalItemRepository;
        this.postalItemService = postalItemService;
        this.postOfficeRepository = postOfficeRepository;
    }

    @GetMapping("postalItems")
    public List<PostalItemDto> getPostalItems() {
        List<PostalItemDto> postalItemsDto = new ArrayList<>();
        postalItemRepository.findAll().forEach(postalItem -> {
            postalItemsDto.add(postalItemService.getDtoFromEntity(postalItem));
        });
        return postalItemsDto;
    }

    @GetMapping("postalItems/{id}")
    public PostalItemDto getPostalItem(@PathVariable Long id) {
        PostalItem postalItem = postalItemRepository.getOne(id);
        return postalItemService.getDtoFromEntity(postalItem);
    }

    @PostMapping(value = "postalItems", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void registerPostalItem(@Valid @RequestBody PostalItemRegistrationDto dtoPostalItem) {

        PostOffice postOffice = postOfficeRepository.findOne(dtoPostalItem.getTargetPostOfficeIndex());

        PostalItem postalItem = new PostalItem();
        postalItem.setTargetPostOffice(postOffice);
        postalItem.setNameReceiver(dtoPostalItem.getNameReceiver());
        postalItem.setPostalItemStatus(PostalItemStatus.isRegistered);
        postalItem.setPostalItemType(dtoPostalItem.getPostalItemType());

        postalItemRepository.save(postalItem);
    }
}
