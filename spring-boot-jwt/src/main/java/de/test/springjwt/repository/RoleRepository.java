package de.test.springjwt.repository;

import java.util.Optional;

import de.test.springjwt.models.ERole;
import de.test.springjwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
