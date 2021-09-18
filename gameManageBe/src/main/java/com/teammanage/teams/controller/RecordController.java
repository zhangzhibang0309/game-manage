package com.teammanage.teams.controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

import com.teammanage.teams.entity.VideoEntity;
import com.teammanage.teams.service.VideoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teammanage.teams.entity.RecordEntity;
import com.teammanage.teams.service.RecordService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-04-02 14:05:52
 */
@RestController
@RequestMapping("teams/record")
public class RecordController {
    @Autowired
    private RecordService recordService;
    private VideoService videoService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("teams:record:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = recordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{recordId}")
    @RequiresPermissions("teams:record:info")
    public R info(@PathVariable("recordId") Integer recordId){
		RecordEntity record = recordService.getById(recordId);

        return R.ok().put("record", record);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("teams:record:save")
    public R save(@RequestBody RecordEntity record){
		recordService.save(record);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("teams:record:update")
    public R update(@RequestBody RecordEntity record){
		recordService.updateById(record);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("teams:record:delete")
    public R delete(@RequestBody Integer[] recordIds){
		recordService.removeByIds(Arrays.asList(recordIds));

        return R.ok();
    }


}
