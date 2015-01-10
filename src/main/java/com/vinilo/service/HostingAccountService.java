package com.vinilo.service;

import com.vinilo.model.HostingAccount;

public interface HostingAccountService extends BaseService<HostingAccount> {

    public HostingAccount searchByUsername(String username);

}
