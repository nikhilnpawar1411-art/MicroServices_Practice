package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto{

    @NotEmpty(message = "Name cannot be null or Empty")
    @Size(min=5, max=40,message = "Customer length should be between 5 to 40")
    private String name;

    @NotEmpty(message = "Email Address cannot be null or Empty")
    @Email(message = "Email should be in valid format")
    private String email;

    @Pattern(regexp = "($|[0-9]{10})",message = "Mobile Number must be 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;

}
