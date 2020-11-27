package com.example.demo.dto;

import com.example.demo.model.PostalItemType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PostalItemRegistrationDto {

    private final PostalItemType postalItemType;
    private final String nameReceiver;
    private final String targetPostOfficeIndex;

    @JsonCreator
    public PostalItemRegistrationDto(@JsonProperty("postalItemType") PostalItemType postalItemType,
                                     @JsonProperty("nameReceiver") String nameReceiver,
                                     @JsonProperty("targetPostOfficeIndex") String targetPostOfficeIndex) {
        this.postalItemType = postalItemType;
        this.nameReceiver = nameReceiver;
        this.targetPostOfficeIndex = targetPostOfficeIndex;
    }

    public PostalItemType getPostalItemType() {
        return postalItemType;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public String getTargetPostOfficeIndex() {
        return targetPostOfficeIndex;
    }
}
