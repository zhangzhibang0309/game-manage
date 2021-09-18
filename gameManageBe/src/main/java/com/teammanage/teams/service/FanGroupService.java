package com.teammanage.teams.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.entity.FanGroupEntity;

import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-05-10 16:36:49
 */
public interface FanGroupService extends IService<FanGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

