package com.vinilo.repository;

import com.vinilo.model.HostingAccount;
import java.util.List;

public interface HostingAccountRepository {
    
    public List<HostingAccount> searchAll();

    public HostingAccount searchById(long id);
    
    public HostingAccount searchByUsername(String username);

    public HostingAccount save(HostingAccount hostingAccount);

    public void remove(HostingAccount hostingAccount);
}
