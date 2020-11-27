package com.example.demo.controller;

import com.example.demo.model.PostOffice;
import com.example.demo.repo.PostOfficeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class PostOfficeController {

    private PostOfficeRepository postOfficeRepository;
    @Autowired
    public PostOfficeController(PostOfficeRepository postOfficeRepository) {
        this.postOfficeRepository = postOfficeRepository;
    }

    @GetMapping("postOffices")
    public List<PostOffice> getPostOffices() {
        List<PostOffice> all = postOfficeRepository.findAll();
        return all;
    }

    @PostMapping(value = "postOffices", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPostOffice(@RequestBody PostOffice postOffice) {
        postOfficeRepository.save(postOffice);
    }


}
