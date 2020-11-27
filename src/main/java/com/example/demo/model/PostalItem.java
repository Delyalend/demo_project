package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "postal_item")
public class PostalItem {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "ID_GENERATOR")
    @Column(name = "id")
    private Long id;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PostalItemType postalItemType;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private PostalItemStatus postalItemStatus;

    @Column(name = "name_receiver", nullable = false)
    private String nameReceiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "target_post_office_index")
    private PostOffice targetPostOffice;

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

    public PostOffice getTargetPostOffice() {
        return targetPostOffice;
    }

    public void setPostalItemType(PostalItemType postalItemType) {
        this.postalItemType = postalItemType;
    }

    public void setPostalItemStatus(PostalItemStatus postalItemStatus) {
        this.postalItemStatus = postalItemStatus;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public void setTargetPostOffice(PostOffice targetPostOffice) {
        this.targetPostOffice = targetPostOffice;
    }



}
