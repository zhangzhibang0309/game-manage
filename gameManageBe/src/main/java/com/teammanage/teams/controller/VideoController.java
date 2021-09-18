package com.teammanage.teams.controller;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teammanage.teams.entity.VideoEntity;
import com.teammanage.teams.service.VideoService;
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
@RequestMapping("teams/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("teams:video:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = videoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{videoId}")
    @RequiresPermissions("teams:video:info")
    public R info(@PathVariable("videoId") Integer videoId){
		VideoEntity video = videoService.getById(videoId);

        return R.ok().put("video", video);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("teams:video:save")
    public R save(@RequestBody VideoEntity video){
		videoService.save(video);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("teams:video:update")
    public R update(@RequestBody VideoEntity video){
		videoService.updateById(video);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("teams:video:delete")
    public R delete(@RequestBody Integer[] videoIds){
		videoService.removeByIds(Arrays.asList(videoIds));

        return R.ok();
    }

    /**
     * 获取视频流
     * @param response
     * @param videoId 视频存放信息索引
     * @return
     * @author xWang
     * @Date 2020-05-20
     */
    @RequestMapping("/getVideo/{videoId}")
    public R getVideo(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer videoId)
    {
        //视频资源存储信息
        VideoEntity videoSource = videoService.getById(videoId);
        if (null == videoSource){
            R.ok().put("msg","找不到视频");

        }
        return R.ok().put("void",videoSource);


    }

}
