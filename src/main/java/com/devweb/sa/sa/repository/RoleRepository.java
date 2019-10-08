package com.devweb.sa.sa.repository;


import com.devweb.sa.sa.model.Role;
import com.devweb.sa.sa.model.RoleName;
import com.devweb.sa.sa.model.Role;
import com.devweb.sa.sa.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}