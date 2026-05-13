package com.petrescue.petrescuesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.User;
import java.time.LocalDateTime;
import java.util.List;

public interface UserService {

    User getById(Long userId);

    boolean save(User user);

    boolean updateById(User user);

    boolean removeById(Long userId);

    User selectByUsername(String username);

    User selectByEmail(String email);

    User selectByPhone(String phone);

    List<User> selectByRole(Integer role);

    List<User> selectByStatus(Integer status);

    IPage<User> selectUserPage(Page<User> page, Integer role, Integer status, String keyword);

    Integer countByRole(Integer role);

    boolean updateStatus(Long userId, Integer status);

    boolean updateLastLogin(Long userId, LocalDateTime lastLogin);

    boolean updatePassword(Long userId, String password);

    List<User> searchUsers(String keyword);

    List<User> selectNewUsers(Integer limit);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);

    boolean checkPhoneExists(String phone);
}