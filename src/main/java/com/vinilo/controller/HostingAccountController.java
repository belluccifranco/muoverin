package com.vinilo.controller;

import com.vinilo.model.HostingAccount;
import com.vinilo.service.HostingAccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HostingAccountController {

    private final HostingAccountService hostingAccountService;

    @Autowired
    public HostingAccountController(HostingAccountService hostingAccountService) {
        this.hostingAccountService = hostingAccountService;
    }

    @RequestMapping(value = "/hostings", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<HostingAccount> searchAllHostingAccounts() {
        return hostingAccountService.searchAll();
    }
}
