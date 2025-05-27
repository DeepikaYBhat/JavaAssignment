package com.Assignment3.CRUD.Example.repository;

import com.Assignment3.CRUD.Example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
