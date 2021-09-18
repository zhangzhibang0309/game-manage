package com.teammanage.teams.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teammanage.teams.entity.TeamEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teammanage.teams.entity.UMemberEntity;
import com.teammanage.teams.service.UMemberService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.R;



/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-04-10 14:33:23
 */
@RestController
@RequestMapping("teams/umember")
public class UMemberController {
    @Autowired
    private UMemberService uMemberService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("teams:umember:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = uMemberService.queryPage(params);

        return R.ok().put("page", page);
    }
    /**
     * 列表
     */
    @RequestMapping("/listId")
    @RequiresPermissions("teams:umember:listId")
    public R listId(){
        ArrayList<Integer> integers = new ArrayList<>();
        List<UMemberEntity> list = uMemberService.list();
        for (UMemberEntity uMemberEntity :
                list) {
            integers.add(uMemberEntity.getMemberId());
        }
        return R.ok().put("listId", integers);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{memberId}")
    @RequiresPermissions("teams:umember:info")
    public R info(@PathVariable("memberId") Integer memberId){
		UMemberEntity uMember = uMemberService.getById(memberId);

        return R.ok().put("uMember", uMember);
    }

    /**
     * 给队员点赞
     * @param memberId
     * @return
     */
    @RequestMapping("/good/{memberId}")
    @RequiresPermissions("teams:umember:good")
    public R good(@PathVariable("memberId") Integer memberId){
        //查询出member
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("member_id", memberId);
        List<UMemberEntity> list = uMemberService.list(queryWrapper);
        for (UMemberEntity uMemberEntity : list) {
            //给member的点赞+1
            uMemberEntity.setMemberSupport(uMemberEntity.getMemberSupport()+1);
        }

        uMemberService.updateBatchById(list);


        return R.ok();
    }

    /**
     * 跟据队伍id返回队员表
     * @param teamId
     * @param params
     * @return
     */
    @RequestMapping("/listByTeamId/{teamId}")
    @RequiresPermissions("teams:umember:listByTeamId")
    public R list(@PathVariable("teamId") Integer teamId,@RequestParam Map<String, Object> params){
//        PageUtils page = uMemberService.queryPage(params);

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("member_team", teamId);
        List<UMemberEntity> list = uMemberService.list(queryWrapper);
        System.out.println(list);
        return R.ok().put("list", list);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("teams:umember:save")
    public R save(@RequestBody UMemberEntity uMember){
		uMemberService.save(uMember);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("teams:umember:update")
    public R update(@RequestBody UMemberEntity uMember){
		uMemberService.updateById(uMember);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("teams:umember:delete")
    public R delete(@RequestBody Integer[] memberIds){
		uMemberService.removeByIds(Arrays.asList(memberIds));

        return R.ok();
    }

}
