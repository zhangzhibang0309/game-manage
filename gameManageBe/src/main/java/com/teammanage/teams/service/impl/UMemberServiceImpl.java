package com.teammanage.teams.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teammanage.teams.common.utils.PageUtils;
import com.teammanage.teams.common.utils.Query;

import com.teammanage.teams.dao.UMemberDao;
import com.teammanage.teams.entity.UMemberEntity;
import com.teammanage.teams.service.UMemberService;


@Service("uMemberService")
public class UMemberServiceImpl extends ServiceImpl<UMemberDao, UMemberEntity> implements UMemberService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UMemberEntity> page = this.page(
                new Query<UMemberEntity>().getPage(params),
                new QueryWrapper<UMemberEntity>()
        );

        return new PageUtils(page);
    }

}