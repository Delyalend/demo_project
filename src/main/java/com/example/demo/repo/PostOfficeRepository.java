package com.example.demo.repo;

import com.example.demo.model.PostOffice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostOfficeRepository {
    List<PostOffice> findAll();
    PostOffice findOne(String index);
    void save(PostOffice postOffice);
}
