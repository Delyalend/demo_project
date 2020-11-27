package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post_office")
public class PostOffice {

    @Id
    @Column(name = "index")
    @Size(
            min = 6,
            max = 6,
            message = "index length must be 6"
    )
    private String index;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "targetPostOffice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostalItem> postalItems = new ArrayList<>();


    public PostOffice(String index, String title, String address) {
        this.index = index;
        this.title = title;
        this.address = address;
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

    public List<PostalItem> getPostalItems() {
        return postalItems;
    }
}
