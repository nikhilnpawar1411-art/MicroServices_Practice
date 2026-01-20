package com.eazybytes.accounts.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity{

    @Id
    @Column(name="account_number")
    private Long accountNumber;

    private Long customerId;

    private String accountType;

    private String branchAddress;



}
