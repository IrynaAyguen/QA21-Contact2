package com.telran.contact.api.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class AddNewContactRequestDto {
    String address;
    String description;
    String email;
    int id;
    String lastName;
    String name;
    String phone;


}

//
//{
//        "address": "string",
//        "description": "string",
//        "email": "string",
//        "id": 0,
//        "lastName": "string",
//        "name": "string",
//        "phone": "string"
//        }
