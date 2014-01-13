package com.vinilo.repository;

import com.vinilo.model.UserAccount;

public interface AccountRepository {

    public UserAccount searchByName(String name);
}
