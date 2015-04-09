package com.muoverin.controller;

import com.muoverin.exception.BusinessValidationException;
import com.muoverin.model.UserAccount;
import com.muoverin.model.UserRole;
import com.muoverin.service.UserAccountService;
import com.muoverin.service.UserAccountValidator;
import com.muoverin.service.UserRoleService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final UserRoleService userRoleService;

    @Autowired
    private UserAccountValidator userAccountValidator;

    @Autowired
    public UserAccountController(UserAccountService userAccountService, UserRoleService userRoleService) {
        this.userAccountService = userAccountService;
        this.userRoleService = userRoleService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value = "/userAccounts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void newUserAccount(@RequestBody @Valid UserAccount userAccount, BindingResult result) {
        List<UserRole> roles = new ArrayList<>();
        roles.add(userRoleService.searchByName("ROLE_CUSTOMER"));
        userAccount.setUserRoles(roles);
        userAccountValidator.validate(userAccount, result);
        if (result.hasErrors()) {
            throw new BusinessValidationException(result);
        }
        userAccountService.save(userAccount);
    }
}
