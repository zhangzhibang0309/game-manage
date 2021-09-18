package com.teammanage.teams.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.Query;

import com.teammanage.teams.dao.ReviewTeamDao;
import com.teammanage.teams.entity.ReviewTeamEntity;
import com.teammanage.teams.service.ReviewTeamService;


@Service("reviewTeamService")
public class ReviewTeamServiceImpl extends ServiceImpl<ReviewTeamDao, ReviewTeamEntity> implements ReviewTeamService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReviewTeamEntity> page = this.page(
                new Query<ReviewTeamEntity>().getPage(params),
                new QueryWrapper<ReviewTeamEntity>()
        );

        return new PageUtils(page);
    }

}