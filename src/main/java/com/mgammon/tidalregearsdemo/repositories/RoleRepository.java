package com.mgammon.tidalregearsdemo.repositories;

import com.mgammon.tidalregearsdemo.models.ERole;
import com.mgammon.tidalregearsdemo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
