package com.telran.contact.api.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class UpdateContactResponseDto {
    String address;
    String description;
    String email;
    int id;
    String lastName;
    String name;
    String phone;
}
