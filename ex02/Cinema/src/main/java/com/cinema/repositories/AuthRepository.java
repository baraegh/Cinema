package com.cinema.repositories;

import java.util.List;

import com.cinema.models.UserAuthentication;

public interface AuthRepository extends CrudeRepository<UserAuthentication> {
    List<UserAuthentication> findByUserId(String userId);
}
