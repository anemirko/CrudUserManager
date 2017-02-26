package ru.nemirko.crudusermanager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nemirko.crudusermanager.model.User;
import ru.nemirko.crudusermanager.repository.UserRepository;


import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserRepository userRepository;


    @Transactional
    public User create(User user) {
        User createdUser = user;

        return userRepository.save(createdUser);
    }


    @Transactional
    public User findById(int id) {
        return userRepository.findOne(id);
    }


    @Transactional
    public User delete(int id) {
        User deletedUser = userRepository.findOne(id);

        userRepository.delete(deletedUser);

        return deletedUser;
    }


    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Transactional
    public User update(User user) {
        User updatedUser = userRepository.findOne(user.getId());
        updatedUser.setName(user.getName());
        updatedUser.setAge(user.getAge());
        updatedUser.setAdmin(user.getAdmin());
        return updatedUser;
    }


    @Transactional
    public List<User> search(String s) {

        return userRepository.findByNameStartingWith(s);

    }

    @Transactional
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional
    public Page<User> findByNameStartingWith(String name, Pageable pageable) {
        return userRepository.findByNameStartingWith(name, pageable);
    }
}
