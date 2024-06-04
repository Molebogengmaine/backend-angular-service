package com.example;

import com.example.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity,Long > {
   // @Query(nativeQuery = true, value = "SELECT emailaddress FROM register");

    Optional<RegisterEntity> findByEmailAddress(String  emailAddress);
}
