package com.sapient.sapient.profile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Profile {

    @Id
    @Column
    private int postId;

    private String bio;

    private Integer likes;

    

//    private Boolean customisation;
    // Employee id foreign key. Get from Josh


}
