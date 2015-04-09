package com.muoverin.repository;

import com.muoverin.model.UserRole;

public interface UserRoleRepository extends BaseRepository<UserRole> {

    public UserRole searchByName(String name);

}
