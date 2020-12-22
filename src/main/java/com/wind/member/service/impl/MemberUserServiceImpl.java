package com.wind.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wind.member.dao.MemberPermissionMapper;
import com.wind.member.dao.MemberUserMapper;
import com.wind.member.entity.MemberPermission;
import com.wind.member.entity.MemberUser;
import com.wind.member.entity.Tablepar;
import com.wind.member.service.MemberUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberUserServiceImpl implements MemberUserService {

    private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_movie_single");

    @Autowired
    private MemberUserMapper memberUserMapper;


    @Override
    public PageInfo<MemberUser> findAll(MemberUser user, Tablepar tablepar) {

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<MemberUser> list= memberUserMapper.findAll(user);
        return new PageInfo<>(list);
    }

    @Override
    public List<MemberUser> findAll(MemberUser user) {
        return memberUserMapper.findAll(user);
    }
}
