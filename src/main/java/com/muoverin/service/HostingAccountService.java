package com.muoverin.service;

import com.muoverin.model.HostingAccount;

public interface HostingAccountService extends BaseService<HostingAccount> {

    public HostingAccount searchByUsername(String username);
    
    public HostingAccount searchByName(String name);

}
