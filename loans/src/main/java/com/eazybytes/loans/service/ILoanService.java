package com.eazybytes.loans.service;

import com.eazybytes.loans.dto.LoansDto;
import jakarta.validation.constraints.Pattern;

public interface ILoanService {
    void createLoan(String mobileNumber);

    LoansDto fetchLoanDetails(@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber);

    boolean updateLoan(LoansDto loansDto);

    boolean deleteLoan(String mobileNumber);
}
