package ru.nemirko.crudusermanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.nemirko.crudusermanager.model.User;

import java.util.List;

/**
 * Created by anemirko on 26.02.17.
 */
public interface UserRepositoryCustom {
    List<User> findByNameStartingWith(String name);
    Page<User> findByNameStartingWith(String name, Pageable pageable);
    Page<User> findAll(Pageable pageable);
}
