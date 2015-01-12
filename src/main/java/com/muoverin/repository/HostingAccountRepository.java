package com.muoverin.repository;

import com.muoverin.model.HostingAccount;

public interface HostingAccountRepository extends BaseRepository<HostingAccount> {

    public HostingAccount searchByUsername(String username);

}
