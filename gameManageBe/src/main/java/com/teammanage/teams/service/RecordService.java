package com.teammanage.teams.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.entity.RecordEntity;

import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-04-02 14:05:52
 */
public interface RecordService extends IService<RecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

