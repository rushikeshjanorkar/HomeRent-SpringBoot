package com.HomeRent.rentApplication.Repository;

import com.HomeRent.rentApplication.Entity.Admin;
import com.HomeRent.rentApplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findByUsername(String username);
}
