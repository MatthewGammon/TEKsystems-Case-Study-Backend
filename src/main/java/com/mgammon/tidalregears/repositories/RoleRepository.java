package com.mgammon.tidalregears.repositories;

import com.mgammon.tidalregears.models.ERole;
import com.mgammon.tidalregears.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
