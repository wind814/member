package com.wind.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wind.member.dao.MemberPermissionMapper;
import com.wind.member.dao.MemberRoleUserMapper;
import com.wind.member.dao.MemberUserMapper;
import com.wind.member.entity.MemberPermission;
import com.wind.member.entity.MemberRole;
import com.wind.member.entity.MemberRoleUser;
import com.wind.member.entity.MemberUser;
import com.wind.member.entity.Tablepar;
import com.wind.member.exception.MemberRoleIsNullException;
import com.wind.member.exception.MemberUserIsNullException;
import com.wind.member.service.MemberUserService;
import com.wind.member.shiro.util.SnowflakeIdWorker;
import com.wind.member.shiro.util.StringUtils;
import com.wind.member.util.MD5Util;
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
    @Autowired
    private MemberRoleUserMapper memberRoleUserMapper;


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

    @Override
    public void deleteMemberUser(String id) {

        MemberUser memberUser = memberUserMapper.selectByPrimaryKey(id);
        if(memberUser==null){
            throw new MemberUserIsNullException();
        }
        try{
            memberUserMapper.deleteByPrimaryKey(id);
            memberRoleUserMapper.deleteByUserId(id);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public int addMemberUser(MemberUser user, List<String> roles) {
        String userId= SnowflakeIdWorker.getUUID();
        user.setId(userId);
        if(StringUtils.isNotEmpty(roles)){
            for (String roleId : roles) {
                MemberRoleUser roleUser=new MemberRoleUser(SnowflakeIdWorker.getUUID(), userId,roleId);
                memberRoleUserMapper.insert(roleUser);
            }
        }

        //密码加密
        user.setPassword(MD5Util.encode(user.getPassword()));
        return memberUserMapper.insert(user);
    }
}
