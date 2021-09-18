package com.teammanage.teams.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.Query;

import com.teammanage.teams.dao.ReviewMatchDao;
import com.teammanage.teams.entity.ReviewMatchEntity;
import com.teammanage.teams.service.ReviewMatchService;


@Service("reviewMatchService")
public class ReviewMatchServiceImpl extends ServiceImpl<ReviewMatchDao, ReviewMatchEntity> implements ReviewMatchService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReviewMatchEntity> page = this.page(
                new Query<ReviewMatchEntity>().getPage(params),
                new QueryWrapper<ReviewMatchEntity>()
        );

        return new PageUtils(page);
    }

}