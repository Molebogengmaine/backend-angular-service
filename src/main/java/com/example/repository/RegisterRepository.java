package com.example.repository;

import com.example.enity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity,Long > {
    Optional<RegisterEntity> findByEmailAddress(String  emailAddress);
    Optional<RegisterEntity> findByPassword(String  password);
}
