package com.muoverin.service;

import com.muoverin.model.UserRole;
import com.muoverin.repository.UserRoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserRole searchByName(String name) {
        return userRoleRepository.searchByName(name);
    }

    @Override
    @Transactional
    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void remove(UserRole userRole) {
        userRoleRepository.remove(userRole);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserRole> searchAll() {
        return userRoleRepository.searchAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UserRole searchById(long id) {
        return userRoleRepository.searchById(id);
    }

}
