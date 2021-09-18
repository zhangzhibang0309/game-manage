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

import com.teammanage.teams.entity.ReviewMemberEntity;
import com.teammanage.teams.service.ReviewMemberService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.R;



/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-04-10 14:47:35
 */
@RestController
@RequestMapping("teams/reviewmember")
public class ReviewMemberController {
    @Autowired
    private ReviewMemberService reviewMemberService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("teams:reviewmember:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = reviewMemberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{reviewId}")
    @RequiresPermissions("teams:reviewmember:info")
    public R info(@PathVariable("reviewId") Integer reviewId){
		ReviewMemberEntity reviewMember = reviewMemberService.getById(reviewId);

        return R.ok().put("reviewMember", reviewMember);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("teams:reviewmember:save")
    public R save(@RequestBody ReviewMemberEntity reviewMember){
		reviewMemberService.save(reviewMember);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("teams:reviewmember:update")
    public R update(@RequestBody ReviewMemberEntity reviewMember){
		reviewMemberService.updateById(reviewMember);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("teams:reviewmember:delete")
    public R delete(@RequestBody Integer[] reviewIds){
		reviewMemberService.removeByIds(Arrays.asList(reviewIds));

        return R.ok();
    }

}
