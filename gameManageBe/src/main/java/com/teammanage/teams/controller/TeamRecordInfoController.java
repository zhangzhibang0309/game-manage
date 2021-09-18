package com.teammanage.teams.controller;

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

import com.teammanage.teams.entity.TeamRecordInfoEntity;
import com.teammanage.teams.service.TeamRecordInfoService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.R;



/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-04-10 17:30:08
 */
@RestController
@RequestMapping("teams/teamrecordinfo")
public class TeamRecordInfoController {
    @Autowired
    private TeamRecordInfoService teamRecordInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("teams:teamrecordinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = teamRecordInfoService.queryPage(params);

        return R.ok().put("page", page);
    }
    /**
     * 跟据对战记录id返回详细记录
     * @param
     * @param params
     * @return
     */
    @RequestMapping("/listInfo/{teamRecordInfoId}")
    @RequiresPermissions("teams:umember:listInfo")
    public R list(@PathVariable("teamRecordInfoId") Integer teamRecordInfoId,@RequestParam Map<String, Object> params){

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("team_record_info_parent", teamRecordInfoId);
        List<TeamRecordInfoEntity> list = teamRecordInfoService.list(queryWrapper);
        System.out.println(list);
//        System.out.println(list);
//        PageUtils page = teamRecordInfoService.queryPage(params);
//        PageUtils page = teamRecordInfoService.queryPage(params);
        return R.ok().put("list", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{teamRecordInfoId}")
    @RequiresPermissions("teams:teamrecordinfo:info")
    public R info(@PathVariable("teamRecordInfoId") Integer teamRecordInfoId){
		TeamRecordInfoEntity teamRecordInfo = teamRecordInfoService.getById(teamRecordInfoId);

        return R.ok().put("teamRecordInfo", teamRecordInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("teams:teamrecordinfo:save")
    public R save(@RequestBody TeamRecordInfoEntity teamRecordInfo){
		teamRecordInfoService.save(teamRecordInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("teams:teamrecordinfo:update")
    public R update(@RequestBody TeamRecordInfoEntity teamRecordInfo){
		teamRecordInfoService.updateById(teamRecordInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("teams:teamrecordinfo:delete")
    public R delete(@RequestBody Integer[] teamRecordInfoIds){
		teamRecordInfoService.removeByIds(Arrays.asList(teamRecordInfoIds));

        return R.ok();
    }

}
