package com.example.demo.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private String firstName;
    private String lastName;
    private boolean isCorporate;
    private int id;
}
