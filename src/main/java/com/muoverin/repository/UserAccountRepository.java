package com.muoverin.repository;

import com.muoverin.model.UserAccount;

public interface UserAccountRepository extends BaseRepository<UserAccount> {

    public UserAccount searchByName(String name);

}
