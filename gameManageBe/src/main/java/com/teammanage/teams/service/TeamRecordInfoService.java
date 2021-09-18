package com.teammanage.teams.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.entity.TeamRecordInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-04-10 17:30:08
 */
public interface TeamRecordInfoService extends IService<TeamRecordInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);


}

