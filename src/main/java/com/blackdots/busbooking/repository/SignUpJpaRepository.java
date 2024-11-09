package com.blackdots.busbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.blackdots.busbooking.model.User;

@Repository
public interface SignUpJpaRepository extends JpaRepository<User, Integer> {

}

