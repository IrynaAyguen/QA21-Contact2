package com.telran.contact.api.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString


public class UpdateContactErrorDto {
    int  code;
    String details;
    String message;
}
