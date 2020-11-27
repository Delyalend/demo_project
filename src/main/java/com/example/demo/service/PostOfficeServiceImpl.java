package com.example.demo.service;

import com.example.demo.dto.PostOfficeDto;
import com.example.demo.model.PostOffice;
import org.springframework.stereotype.Service;

@Service
public class PostOfficeServiceImpl implements PostOfficeService {
    @Override
    public PostOffice getEntityFromDto(PostOfficeDto postalItemDto) {
        return null;
    }

    @Override
    public PostOfficeDto getDtoFromEntity(PostOffice postOffice) {
        PostOfficeDto postOfficeDto = new PostOfficeDto(
                postOffice.getIndex(),
                postOffice.getTitle(),
                postOffice.getAddress());
        return null;
    }
}
