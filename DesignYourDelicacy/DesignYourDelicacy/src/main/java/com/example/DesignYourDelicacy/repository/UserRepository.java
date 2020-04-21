package com.example.DesignYourDelicacy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DesignYourDelicacy.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByNameAndPwd(String name, String pwd);

}
