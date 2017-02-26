package ru.nemirko.crudusermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nemirko.crudusermanager.model.User;

/**
 * Created by anemirko on 26.02.17.
 */
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
}
