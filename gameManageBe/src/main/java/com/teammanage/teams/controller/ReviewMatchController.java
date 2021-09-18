package com.teammanage.teams.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teammanage.teams.entity.ReviewMatchEntity;
import com.teammanage.teams.service.ReviewMatchService;
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
@RequestMapping("teams/reviewmatch")
public class ReviewMatchController {
    @Autowired
    private ReviewMatchService reviewMatchService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("teams:reviewmatch:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = reviewMatchService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{reviewId}")
    @RequiresPermissions("teams:reviewmatch:info")
    public R info(@PathVariable("reviewId") Integer reviewId){
		ReviewMatchEntity reviewMatch = reviewMatchService.getById(reviewId);

        return R.ok().put("reviewMatch", reviewMatch);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("teams:reviewmatch:save")
    public R save(@RequestBody ReviewMatchEntity reviewMatch){
		reviewMatchService.save(reviewMatch);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("teams:reviewmatch:update")
    public R update(@RequestBody ReviewMatchEntity reviewMatch){
		reviewMatchService.updateById(reviewMatch);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("teams:reviewmatch:delete")
    public R delete(@RequestBody Integer[] reviewIds){
		reviewMatchService.removeByIds(Arrays.asList(reviewIds));

        return R.ok();
    }

}
