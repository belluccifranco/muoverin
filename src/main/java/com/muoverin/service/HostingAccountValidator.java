package com.muoverin.service;

import com.muoverin.model.HostingAccount;
import com.muoverin.repository.HostingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class HostingAccountValidator implements Validator {

    @Autowired
    private HostingAccountRepository hostingAccountRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return HostingAccount.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        HostingAccount hostingAccount = (HostingAccount) target;
        if (hostingAccountRepository.searchByName(hostingAccount.getName()) != null) {
            errors.rejectValue("name", "Duplicate");
        }
    }
}
