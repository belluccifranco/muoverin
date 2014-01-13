package com.vinilo.service;

import com.vinilo.model.UserAccount;

public interface AccountService {

    public void login();

    public void logout();

    public UserAccount save(UserAccount account);
}
