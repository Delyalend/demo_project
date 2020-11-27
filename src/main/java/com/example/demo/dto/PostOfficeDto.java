package com.example.demo.dto;

import com.example.demo.model.PostalItem;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostOfficeDto {
    private final String index;
    private final String title;
    private final String address;
    private final List<PostalItem> postalItems;


    @JsonCreator
    public PostOfficeDto(@JsonProperty("index")String index,
                         @JsonProperty("title")String title,
                         @JsonProperty("address")String address) {
        this.index = index;
        this.title = title;
        this.address = address;
        this.postalItems = new ArrayList<>();
    }

    @JsonCreator
    public PostOfficeDto(String index, String title, String address, List<PostalItem> postalItems) {
        this.index = index;
        this.title = title;
        this.address = address;
        this.postalItems = Collections.unmodifiableList(postalItems);
    }

    public String getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }


}
