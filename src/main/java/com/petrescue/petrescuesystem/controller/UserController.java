package com.petrescue.petrescuesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.common.Result;
import com.petrescue.petrescuesystem.entity.User;
import com.petrescue.petrescuesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Result<User> getById(@PathVariable Long userId) {
        return Result.success(userService.getById(userId));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody User user) {
        return Result.success(userService.save(user));
    }

    @PutMapping
    public Result<Boolean> updateById(@RequestBody User user) {
        return Result.success(userService.updateById(user));
    }

    @DeleteMapping("/{userId}")
    public Result<Boolean> removeById(@PathVariable Long userId) {
        return Result.success(userService.removeById(userId));
    }

    @GetMapping("/username/{username}")
    public Result<User> selectByUsername(@PathVariable String username) {
        return Result.success(userService.selectByUsername(username));
    }

    @GetMapping("/email/{email}")
    public Result<User> selectByEmail(@PathVariable String email) {
        return Result.success(userService.selectByEmail(email));
    }

    @GetMapping("/phone/{phone}")
    public Result<User> selectByPhone(@PathVariable String phone) {
        return Result.success(userService.selectByPhone(phone));
    }

    @GetMapping("/role/{role}")
    public Result<List<User>> selectByRole(@PathVariable Integer role) {
        return Result.success(userService.selectByRole(role));
    }

    @GetMapping("/status/{status}")
    public Result<List<User>> selectByStatus(@PathVariable Integer status) {
        return Result.success(userService.selectByStatus(status));
    }

    @GetMapping("/page")
    public Result<IPage<User>> selectUserPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                              @RequestParam(required = false) Integer role,
                                              @RequestParam(required = false) Integer status,
                                              @RequestParam(required = false) String keyword) {
        Page<User> page = new Page<>(pageNum, pageSize);
        return Result.success(userService.selectUserPage(page, role, status, keyword));
    }

    @GetMapping("/count/role/{role}")
    public Result<Integer> countByRole(@PathVariable Integer role) {
        return Result.success(userService.countByRole(role));
    }

    @PutMapping("/status")
    public Result<Boolean> updateStatus(@RequestParam Long userId, @RequestParam Integer status) {
        return Result.success(userService.updateStatus(userId, status));
    }

    @PutMapping("/last-login")
    public Result<Boolean> updateLastLogin(@RequestParam Long userId, @RequestParam LocalDateTime lastLogin) {
        return Result.success(userService.updateLastLogin(userId, lastLogin));
    }

    @PutMapping("/password")
    public Result<Boolean> updatePassword(@RequestParam Long userId, @RequestParam String password) {
        return Result.success(userService.updatePassword(userId, password));
    }

    @GetMapping("/search")
    public Result<List<User>> searchUsers(@RequestParam String keyword) {
        return Result.success(userService.searchUsers(keyword));
    }

    @GetMapping("/new-users")
    public Result<List<User>> selectNewUsers(@RequestParam(defaultValue = "10") Integer limit) {
        return Result.success(userService.selectNewUsers(limit));
    }

    @GetMapping("/check/username")
    public Result<Boolean> checkUsernameExists(@RequestParam String username) {
        return Result.success(userService.checkUsernameExists(username));
    }

    @GetMapping("/check/email")
    public Result<Boolean> checkEmailExists(@RequestParam String email) {
        return Result.success(userService.checkEmailExists(email));
    }

    @GetMapping("/check/phone")
    public Result<Boolean> checkPhoneExists(@RequestParam String phone) {
        return Result.success(userService.checkPhoneExists(phone));
    }
}