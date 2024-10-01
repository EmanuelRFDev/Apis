package com.example.apiUserInterview.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiUserInterview.persistence.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
