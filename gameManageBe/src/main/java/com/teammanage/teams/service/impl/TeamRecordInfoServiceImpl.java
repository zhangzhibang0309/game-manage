package com.teammanage.teams.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.Query;

import com.teammanage.teams.dao.TeamRecordInfoDao;
import com.teammanage.teams.entity.TeamRecordInfoEntity;
import com.teammanage.teams.service.TeamRecordInfoService;


@Service("teamRecordInfoService")
public class TeamRecordInfoServiceImpl extends ServiceImpl<TeamRecordInfoDao, TeamRecordInfoEntity> implements TeamRecordInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TeamRecordInfoEntity> page = this.page(
                new Query<TeamRecordInfoEntity>().getPage(params),
                new QueryWrapper<TeamRecordInfoEntity>()
        );

        return new PageUtils(page);
    }

}