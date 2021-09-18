package com.teammanage.teams.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teammanage.teams.entity.UserEntity;
import com.teammanage.teams.service.UserService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.R;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-04-01 19:25:44
 */
@RestController
@RequestMapping("teams/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 登陆
     */
    @RequestMapping("/login")
    @RequiresPermissions("teams:user:login")
    public R login(@RequestParam Long userId,@RequestParam String userPassword){
        System.out.println("Debug========="+userId);

        if (userService.login(userId,userPassword)!=-1){
            UserEntity user = userService.getById(userId);
            return R.ok().put("user", user);
        }else{
            return R.ok("账号或密码错误，登录失败！！");
//            return R.error().put("info", "登录失败");
        }
    }



    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("teams:user:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("teams:user:info")
    public R info(@PathVariable("userId") Long userId){
		UserEntity user = userService.getById(userId);

        return R.ok().put("user", user);
    }

    /**
     * 封号
     * 状态 0 正常，1 封号
     */
    @RequestMapping("/kill/{userId}")
    @RequiresPermissions("teams:user:kill")
    public R kill(@PathVariable("userId") Long userId){
        UserEntity userEntity = userService.getById(userId);
        userEntity.setUserStatus(1);
        userService.updateById(userEntity);
//        UserEntity user = userService.getById(userId);
//        return R.ok().put("user", user);
        return R.ok();
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("teams:user:save")
    public R save(@RequestBody UserEntity user){
		userService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("teams:user:update")
    public R update(@RequestBody UserEntity user){
		userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("teams:user:delete")
    public R delete(@RequestBody Long[] userIds){
		userService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
