package com.teammanage.teams.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.Query;

import com.teammanage.teams.dao.FanGroupDao;
import com.teammanage.teams.entity.FanGroupEntity;
import com.teammanage.teams.service.FanGroupService;


@Service("fanGroupService")
public class FanGroupServiceImpl extends ServiceImpl<FanGroupDao, FanGroupEntity> implements FanGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FanGroupEntity> page = this.page(
                new Query<FanGroupEntity>().getPage(params),
                new QueryWrapper<FanGroupEntity>()
        );

        return new PageUtils(page);
    }

}