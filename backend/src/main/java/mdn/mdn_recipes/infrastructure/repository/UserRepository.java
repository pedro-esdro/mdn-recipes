package mdn.mdn_recipes.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import mdn.mdn_recipes.domain.model.User;



public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

}
