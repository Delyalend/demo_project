package com.example.demo.repo;

import com.example.demo.model.PostalItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostalItemRepository {
    List<PostalItem> findAll();

    PostalItem getOne(Long id);

    void save(PostalItem postalItem);
}
