package com.vinilo.repository;

import com.vinilo.model.HostingAccount;

public interface HostingAccountRepository extends BaseRepository<HostingAccount> {

    public HostingAccount searchByUsername(String username);

}
