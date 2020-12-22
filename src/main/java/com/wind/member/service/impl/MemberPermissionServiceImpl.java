package com.wind.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wind.member.dao.MemberMapper;
import com.wind.member.dao.MemberOperationsMapper;
import com.wind.member.dao.MemberPermissionMapper;
import com.wind.member.dao.MemberRecordMapper;
import com.wind.member.entity.MemberPermission;
import com.wind.member.entity.MemberRecord;
import com.wind.member.entity.Tablepar;
import com.wind.member.service.MemberPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberPermissionServiceImpl implements MemberPermissionService {

    private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_movie_single");

    @Autowired
    private MemberPermissionMapper memberPermissionMapper;


    @Override
    public PageInfo<MemberPermission> findAll(MemberPermission memberPermission, Tablepar tablepar) {

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<MemberPermission> list= memberPermissionMapper.findAll(memberPermission);
        return new PageInfo<>(list);
    }

    @Override
    public List<MemberPermission> findAll(MemberPermission memberPermission) {
        return memberPermissionMapper.findAll(memberPermission);
    }
}
