package com.vinilo.repository;

import com.vinilo.model.UserAccount;

public interface UserAccountRepository {

    public UserAccount searchByName(String name);
    
    public UserAccount save(UserAccount userAccount);
}
