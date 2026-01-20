package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constant.AccountsConstant;
import com.eazybytes.accounts.dto.AccountsContactInfoDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api",produces = MediaType.APPLICATION_JSON_VALUE)
//@AllArgsConstructor
public class AccountsController {

 /*   @GetMapping("callHello")
    public String sayHello(){
        return "Hello, World !!!!";
    }*/

    @Autowired
    private IAccountService iAccountService;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment environment;

    @Autowired
    private AccountsContactInfoDto accountsContactInfoDto;

    @PostMapping("/create")
    private ResponseEntity<ResponseDto> createCustomer(@Valid @RequestBody CustomerDto customerDto){

        iAccountService.createAccount(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstant.STATUS_201,AccountsConstant.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
                                @Pattern(regexp = "($|[0-9]{10})",message="Mobile number must be 10 digits")
                                String mobileNumber){

        return ResponseEntity.status(HttpStatus.OK).body(iAccountService.fetchAccountDetails(mobileNumber));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto){

        boolean isUpdated=iAccountService.updateAccountDetails(customerDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).
                    body(new ResponseDto(AccountsConstant.STATUS_200,AccountsConstant.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR   ).
                    body(new ResponseDto(AccountsConstant.STATUS_500,AccountsConstant.MESSAGE_500));
        }

    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam String mobileNumber){

        boolean isDeleted=iAccountService.deleteAccount(mobileNumber);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstant.STATUS_200,AccountsConstant.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR   )
                    .body(new ResponseDto(AccountsConstant.STATUS_500,AccountsConstant.MESSAGE_500));
        }
    }

    @GetMapping("/build-info")
    public ResponseEntity<String> buildVerion(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(buildVersion);

    }

    @GetMapping("/java-version")
    public ResponseEntity<String> JavaVerion(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(environment.getProperty("MAVEN_HOME"));

    }

    @GetMapping("/contact-info")
    public ResponseEntity<AccountsContactInfoDto> contactVerion(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountsContactInfoDto);

    }

}
