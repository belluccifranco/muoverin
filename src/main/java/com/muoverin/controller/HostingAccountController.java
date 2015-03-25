package com.muoverin.controller;

import com.muoverin.model.HostingAccount;
import com.muoverin.service.HostingAccountService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class HostingAccountController {

    private final HostingAccountService hostingAccountService;

    @Autowired
    public HostingAccountController(HostingAccountService hostingAccountService) {
        this.hostingAccountService = hostingAccountService;
    }

    @RequestMapping(value = "/hostingAccounts", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<HostingAccount> searchAllHostingAccounts() {
        return hostingAccountService.searchAll();
    }
    
    
    @RequestMapping(value = "/hostingAccount", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addNew(@RequestBody @Valid HostingAccount hostingAccount, HttpServletResponse response, WebRequest webRequest, BindingResult result) {
        HostingAccount createdHostingAccount = hostingAccountService.save(hostingAccount);
        response.setHeader("Location", webRequest.getContextPath() + "/hostingAccount/" + createdHostingAccount.getId_hostingAccount());
    }
}
