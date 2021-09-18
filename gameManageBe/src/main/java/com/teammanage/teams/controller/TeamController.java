package com.teammanage.teams.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.teammanage.teams.entity.UMemberEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teammanage.teams.entity.TeamEntity;
import com.teammanage.teams.service.TeamService;
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
@RequestMapping("teams/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("teams:team:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = teamService.queryPage(params);

        return R.ok().put("page", page);
    }
    /**
     * 返回所有id列表
     */
    @RequestMapping("/listId")
    @RequiresPermissions("teams:team:listId")
    public R list(){
        ArrayList<Integer> integers = new ArrayList<>();
        List<TeamEntity> list = teamService.list();
        for (TeamEntity team :
                list) {
            integers.add(team.getTeamId());
        }
        return R.ok().put("listId", integers);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{teamId}")
    @RequiresPermissions("teams:team:info")
    public R info(@PathVariable("teamId") Integer teamId){
		TeamEntity team = teamService.getById(teamId);

        return R.ok().put("team", team);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("teams:team:save")
    public R save(@RequestBody TeamEntity team){
		teamService.save(team);

        return R.ok();
    }
    /**
     * 给队伍点赞
     * @param
     * @return
     */
    @RequestMapping("/good/{teamId}")
    @RequiresPermissions("teams:team:good")
    public R good(@PathVariable("teamId") Integer teamId){
        //查询出team
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("team_id", teamId);
        List<TeamEntity> list = teamService.list(queryWrapper);
        for (TeamEntity teamEntity : list) {
            //给team的点赞+1
            teamEntity.setTeamSupport(teamEntity.getTeamSupport()+1);
        }
        teamService.updateBatchById(list);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("teams:team:update")
    public R update(@RequestBody TeamEntity team){
		teamService.updateById(team);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("teams:team:delete")
    public R delete(@RequestBody Integer[] teamIds){
		teamService.removeByIds(Arrays.asList(teamIds));

        return R.ok();
    }

}
