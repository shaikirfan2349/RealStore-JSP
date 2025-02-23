package com.example.Real_Store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long UserId;
    private String userName;
    private String password;
    private String mobile;
    private String address;
    private String email;
}
