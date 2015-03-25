package com.muoverin.service;

import com.muoverin.model.HostingAccount;
import com.muoverin.repository.HostingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class HostingAccountValidator {
    
    @Autowired
    private HostingAccountRepository hostingAccountRepository;
    
    public void validate(HostingAccount hostingAccount, Errors errors) {
        
        if (hostingAccountRepository.searchByName(hostingAccount.getName()) != null) {
            errors.rejectValue("name", "Duplicate");
        }
    }
}
