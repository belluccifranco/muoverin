package com.vinilo.repository;

import com.vinilo.model.UserAccount;

public interface UserAccountRepository extends BaseRepository<UserAccount> {

    public UserAccount searchByName(String name);

}
