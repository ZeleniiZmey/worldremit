package com.worldremit.model;

import lombok.Value;

@Value
public class UserDataModel {
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
}
