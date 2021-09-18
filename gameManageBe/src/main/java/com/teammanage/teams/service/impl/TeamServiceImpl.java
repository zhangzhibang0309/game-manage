package com.teammanage.teams.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.Query;

import com.teammanage.teams.dao.TeamDao;
import com.teammanage.teams.entity.TeamEntity;
import com.teammanage.teams.service.TeamService;


@Service("teamService")
public class TeamServiceImpl extends ServiceImpl<TeamDao, TeamEntity> implements TeamService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TeamEntity> page = this.page(
                new Query<TeamEntity>().getPage(params),
                new QueryWrapper<TeamEntity>()
        );

        return new PageUtils(page);
    }

}