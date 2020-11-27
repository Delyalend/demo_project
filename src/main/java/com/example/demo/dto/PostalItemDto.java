package com.example.demo.dto;

import com.example.demo.model.PostalItemStatus;
import com.example.demo.model.PostalItemType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostalItemDto {

    private final Long id;

    private final PostalItemType postalItemType;

    private final PostalItemStatus postalItemStatus;

    private final String nameReceiver;

    private final String postOfficeIndex;

    @JsonCreator
    public PostalItemDto(@JsonProperty("id") Long id,
                         @JsonProperty("type") PostalItemType postalItemType,
                         @JsonProperty("status") PostalItemStatus postalItemStatus,
                         @JsonProperty("nameReceiver") String nameReceiver,
                         @JsonProperty("postOfficeIndex") String postOfficeIndex) {

        this.id = id;
        this.postalItemType = postalItemType;
        this.postalItemStatus = postalItemStatus;
        this.nameReceiver = nameReceiver;
        this.postOfficeIndex = postOfficeIndex;
    }

    public Long getId() {
        return id;
    }


    public PostalItemType getPostalItemType() {
        return postalItemType;
    }

    public PostalItemStatus getPostalItemStatus() {
        return postalItemStatus;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }


    public String getPostOfficeIndex() {
        return postOfficeIndex;
    }


}
