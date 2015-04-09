package com.muoverin.service;

import com.muoverin.model.UserAccount;
import com.muoverin.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class UserAccountValidator implements Validator {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserAccount.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserAccount userAccount = (UserAccount) target;
        if (!userAccount.getPassword().equals(userAccount.getCpassword())) {
            errors.rejectValue("cpassword", "NotMatch");
        }
        if (userAccountRepository.searchByUsername(userAccount.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate");
        }
    }

}
