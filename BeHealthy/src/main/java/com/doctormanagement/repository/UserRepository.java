package com.doctormanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctormanagement.model.User;

 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhonenumber(String phonenumber);
    Boolean existsByPhonenumber(String phonenumber);
    Boolean existsByEmail(String email);
}
