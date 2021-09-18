package com.teammanage.teams.controller;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teammanage.teams.entity.UserEntity;
import com.teammanage.teams.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teammanage.teams.entity.FanGroupEntity;
import com.teammanage.teams.service.FanGroupService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.R;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-05-10 16:36:49
 */
@RestController
@RequestMapping("teams/fangroup")
public class FanGroupController {
    @Autowired
    private FanGroupService fanGroupService;
    @Autowired
    private UserService userService;


    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("teams:fangroup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fanGroupService.queryPage(params);
        return R.ok().put("page", page);

    }


    /**
     * 信息
     * 返回战队信息，返回粉丝列表
     */
    @RequestMapping("/info/{groupId}")
    @RequiresPermissions("teams:fangroup:info")
    public R info(@PathVariable("groupId") Integer groupId){
		FanGroupEntity fanGroup = fanGroupService.getById(groupId);

		String[] fans = fanGroup.getGroupMember().split(",");

        List<UserEntity> userEntityList =  new ArrayList<UserEntity>();

        for (String fanid :
                fans) {
            if (null != fanid){
                System.out.println("==================");
                System.out.println(fanid);
                long id = Long.parseLong(fanid);
                System.out.println(id);
                UserEntity user = userService.getById(id);
                userEntityList.add(user);
            }
        }

        //返回战队信息，返回粉丝列表
        return R.ok().put("fanGroup", fanGroup).put("fans", userEntityList);
    }
    /**
     * 加入粉丝团
     * memberId 会员的id
     * groupId  粉丝团id
     */
    @PostMapping("/addmember")
    @RequiresPermissions("teams:fangroup:addmember")
    public R info(@RequestParam (value = "memberId") Long memberId,@RequestParam (value = "groupId") Integer groupId){
//        System.out.println("==========");
        FanGroupEntity fanGroup = fanGroupService.getById(groupId);

        if (null == fanGroup){
            return R.ok().put("msg","找不到对象,请新建一个粉丝团");
        }
        String[] fans = fanGroup.getGroupMember().split(",");

        //判断是否之前已经加入
        for (String fanid :
                fans) {
            if(fanid .equals(memberId)){
                //已经存在， msg = echo
                return R.ok().put("msg","echo");
            }
        }
        //添加新会员
        String groupMember = fanGroup.getGroupMember()+","+memberId.toString();
        fanGroup.setGroupMember(groupMember);

        fanGroupService.updateById(fanGroup);

        System.out.println(groupMember);
        //成功返回 msg = ok
        return R.ok().put("msg", "ok");

    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("teams:fangroup:save")
    public R save(@RequestBody FanGroupEntity fanGroup){
		fanGroupService.save(fanGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("teams:fangroup:update")
    public R update(@RequestBody FanGroupEntity fanGroup){
		fanGroupService.updateById(fanGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("teams:fangroup:delete")
    public R delete(@RequestBody Integer[] groupIds){
		fanGroupService.removeByIds(Arrays.asList(groupIds));

        return R.ok();
    }

}
