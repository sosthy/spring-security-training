package com.example.demo.security.repositories;

import com.example.demo.security.models.AppAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppAuthorityRepository extends JpaRepository<AppAuthority, Long> {
}
