package com.petrescue.petrescuesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.petrescue.petrescuesystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectByUsername(@Param("username") String username);

    User selectByPhone(@Param("phone") String phone);

    User selectByEmail(@Param("email") String email);

    List<User> selectByUserType(@Param("userType") Integer userType);

    List<User> selectByStatus(@Param("status") Integer status);

    IPage<User> selectUserPage(
            Page<User> page,
            @Param("userType") Integer userType,
            @Param("status") Integer status
    );

    Integer countByUserType(@Param("userType") Integer userType);

    Integer updateStatus(
            @Param("userId") Long userId,
            @Param("status") Integer status
    );

    Integer updatePassword(
            @Param("userId") Long userId,
            @Param("passwordHash") String passwordHash
    );

    List<User> searchUsers(@Param("keyword") String keyword);

    List<User> selectRecentRegistered(@Param("limit") Integer limit);

    Integer updateLastLogin(
            @Param("userId") Long userId,
            @Param("lastLogin") java.time.LocalDateTime lastLogin
    );

    Integer checkUsernameExists(@Param("username") String username);

    Integer checkEmailExists(@Param("email") String email);

    Integer checkPhoneExists(@Param("phone") String phone);
}