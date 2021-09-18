package com.teammanage.teams.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.entity.UMemberEntity;

import java.util.Map;

/**
 * 
 *
 * @author 
 * @email 
 * @date 2021-04-10 14:33:23
 */
public interface UMemberService extends IService<UMemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

