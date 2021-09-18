package com.teammanage.teams.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.entity.UserEntity;

import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-04-01 19:25:44
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);


    //用户登陆

    /**
     * 用户登录
     * @param userId 用户id
     * @param userPassword 用户密码
     * @return -1 登录失败；0游客；1会员；2管理员
     */
    public default int login(Long userId, String userPassword){
        UserEntity userEntity = getById(userId);
        if (userEntity != null){
            if (userEntity.getUserPassword().equals(userPassword))  {
                return userEntity.getUserPower();
            }
        }
        return -1;
    }
}

