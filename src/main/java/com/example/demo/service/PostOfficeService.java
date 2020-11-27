package com.example.demo.service;

import com.example.demo.dto.PostOfficeDto;
import com.example.demo.model.PostOffice;

public interface PostOfficeService {
    PostOffice getEntityFromDto(PostOfficeDto postalItemDto);

    PostOfficeDto getDtoFromEntity(PostOffice postalItem);
}
