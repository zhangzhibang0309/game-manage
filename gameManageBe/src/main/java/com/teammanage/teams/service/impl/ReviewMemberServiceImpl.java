package com.teammanage.teams.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.Query;

import com.teammanage.teams.dao.ReviewMemberDao;
import com.teammanage.teams.entity.ReviewMemberEntity;
import com.teammanage.teams.service.ReviewMemberService;


@Service("reviewMemberService")
public class ReviewMemberServiceImpl extends ServiceImpl<ReviewMemberDao, ReviewMemberEntity> implements ReviewMemberService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReviewMemberEntity> page = this.page(
                new Query<ReviewMemberEntity>().getPage(params),
                new QueryWrapper<ReviewMemberEntity>()
        );

        return new PageUtils(page);
    }

}