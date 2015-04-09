package com.muoverin.service;

import com.muoverin.model.UserRole;

public interface UserRoleService extends BaseService<UserRole> {

    public UserRole searchByName(String name);

}
