package ru.nemirko.crudusermanager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.nemirko.crudusermanager.model.User;

import java.util.List;

/**
 * Created by anemirko on 26.02.17.
 */
public interface UserService {
    public User create(User user);
    public User delete(int id);
    public List<User> findAll();
    public User update(User user);
    public User findById(int id);
    public List<User> search(String s);

    public Page<User> findAll(Pageable pageable);
    public Page<User> findByNameStartingWith(String name, Pageable pageable);
}
