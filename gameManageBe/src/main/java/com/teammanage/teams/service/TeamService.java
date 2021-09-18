package com.teammanage.teams.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.entity.TeamEntity;

import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-04-01 19:25:44
 */
public interface TeamService extends IService<TeamEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

