package com.vinilo.service;

import com.vinilo.model.HostingAccount;
import com.vinilo.repository.HostingAccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HostingAccountServiceImpl implements HostingAccountService {

    private final HostingAccountRepository hostingAccountRepository;

    @Autowired
    public HostingAccountServiceImpl(HostingAccountRepository hostingAccountRepository) {
        this.hostingAccountRepository = hostingAccountRepository;
    }   
    
    @Override
    @Transactional(readOnly = true)
    public List<HostingAccount> searchAll() {
        return hostingAccountRepository.searchAll();
    }

    @Override
    @Transactional(readOnly = true)
    public HostingAccount searchById(long id) {
        return hostingAccountRepository.searchById(id);
    }

    @Override
    @Transactional
    public HostingAccount save(HostingAccount hostingAccount) {
        return hostingAccountRepository.save(hostingAccount);
    }

    @Override
    public void remove(HostingAccount hostingAccount) {
        hostingAccountRepository.remove(hostingAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public HostingAccount searchByUsername(String username) {
        return hostingAccountRepository.searchByUsername(username);
    }
    
}
