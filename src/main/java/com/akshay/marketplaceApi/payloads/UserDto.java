package com.akshay.marketplaceApi.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    @NotEmpty
    @Size(min = 2, message = "Username must be of minimum 2 characters")
    private String name;
    @Email(message = "Email address is not valid!!")
    private String email;
    @NotEmpty
    @Size(min = 3, max = 10, message = "password must be between 3-10 characters")
    private String password;
}
