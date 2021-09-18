package com.teammanage.teams.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.entity.ReviewTeamEntity;

import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-04-10 14:47:35
 */
public interface ReviewTeamService extends IService<ReviewTeamEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

