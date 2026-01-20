package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @NotEmpty(message = "Account Number cannot be null or Empty")
    @Pattern(regexp = "($|[0-10]{10})",message = "Mobile Number must be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "Account type cannot be null or Empty")
    private String accountType;

    @NotEmpty(message = "branch address  cannot be null or Empty")
    private String branchAddress;

}
