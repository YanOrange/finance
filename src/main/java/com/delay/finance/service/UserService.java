package com.delay.finance.service;


import com.delay.finance.entity.User;

import java.util.List;

public interface UserService {
    User findById(Integer authorId);

    void saveOrUpdate(User comAuthor);

    List<User> findAllByStatus(int i);

    void delete(Integer userId);

    User findByAccount(String account);

    User findByAccountAndPassWord(String userName, String passWord);
}
