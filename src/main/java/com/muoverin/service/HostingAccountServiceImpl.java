package com.muoverin.service;

import com.muoverin.exception.BusinessValidationException;
import com.muoverin.model.HostingAccount;
import com.muoverin.repository.HostingAccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

@Service
public class HostingAccountServiceImpl implements HostingAccountService {

    private final HostingAccountRepository hostingAccountRepository;
    
    @Autowired
    private HostingAccountValidator hostingAccountValidator;

    @Autowired
    public HostingAccountServiceImpl(HostingAccountRepository hostingAccountRepository) {
        this.hostingAccountRepository = hostingAccountRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<HostingAccount> searchAll() {
        List<HostingAccount> hostings = hostingAccountRepository.searchAll();
        for (HostingAccount hosting : hostings) {
            hosting.setPassword("");
            hosting.setUrl("");
        }
        return hostings;
    }

    @Override
    @Transactional(readOnly = true)
    public HostingAccount searchById(long id) {
        return hostingAccountRepository.searchById(id);
    }

    @Override
    @Transactional
    public HostingAccount save(HostingAccount hostingAccount) {
        BindingResult result = new BeanPropertyBindingResult(hostingAccount, "hostingAccount");

        hostingAccountValidator.validate(hostingAccount, result);
        if (result.hasErrors()) {
            throw new BusinessValidationException(result);
        }

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

    @Override
    @Transactional(readOnly = true)
    public HostingAccount searchByName(String name) {
        return hostingAccountRepository.searchByName(name);
    }

}
