package com.petrescue.petrescuesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.User;
import com.petrescue.petrescuesystem.mapper.UserMapper;
import com.petrescue.petrescuesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public boolean save(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean updateById(User user) {
        return userMapper.updateById(user) > 0;
    }

    @Override
    public boolean removeById(Long userId) {
        return userMapper.deleteById(userId) > 0;
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public User selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    @Override
    public List<User> selectByRole(Integer role) {
        return userMapper.selectByUserType(role);
    }

    @Override
    public List<User> selectByStatus(Integer status) {
        return userMapper.selectByStatus(status);
    }

    @Override
    public IPage<User> selectUserPage(Page<User> page, Integer role, Integer status, String keyword) {
        return userMapper.selectUserPage(page, role, status);
    }

    @Override
    public Integer countByRole(Integer role) {
        return userMapper.countByUserType(role);
    }

    @Override
    public boolean updateStatus(Long userId, Integer status) {
        return userMapper.updateStatus(userId, status) > 0;
    }

    @Override
    public boolean updateLastLogin(Long userId, LocalDateTime lastLogin) {
        return userMapper.updateLastLogin(userId, lastLogin) > 0;
    }

    @Override
    public boolean updatePassword(Long userId, String password) {
        return userMapper.updatePassword(userId, password) > 0;
    }

    @Override
    public List<User> searchUsers(String keyword) {
        return userMapper.searchUsers(keyword);
    }

    @Override
    public List<User> selectNewUsers(Integer limit) {
        return userMapper.selectRecentRegistered(limit);
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return userMapper.checkUsernameExists(username) > 0;
    }

    @Override
    public boolean checkEmailExists(String email) {
        return userMapper.checkEmailExists(email) > 0;
    }

    @Override
    public boolean checkPhoneExists(String phone) {
        return userMapper.checkPhoneExists(phone) > 0;
    }
}