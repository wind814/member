package com.wind.member.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wind.member.dao.MemberPermissionRoleMapper;
import com.wind.member.dao.MemberRoleMapper;
import com.wind.member.entity.MemberPermission;
import com.wind.member.entity.MemberPermissionRole;
import com.wind.member.entity.MemberRole;
import com.wind.member.entity.MemberRole;
import com.wind.member.entity.Tablepar;
import com.wind.member.exception.MemberRoleIsNullException;
import com.wind.member.service.MemberRoleService;
import com.wind.member.service.MemberRoleService;
import com.wind.member.shiro.util.SnowflakeIdWorker;
import com.wind.member.util.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberRoleServiceImpl implements MemberRoleService {

    private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_movie_single");

    @Autowired
    private MemberRoleMapper memberRoleMapper;

    @Autowired
    private MemberPermissionRoleMapper memberPermissionRoleMapper;

    @Override
    public PageInfo<MemberRole> findAll(MemberRole user, Tablepar tablepar) {

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<MemberRole> list= memberRoleMapper.findAll(user);
        return new PageInfo<>(list);
    }

    @Override
    public List<MemberRole> findAll(MemberRole user) {
        return memberRoleMapper.findAll(user);
    }

    @Override
    public int addMemberRole(MemberRole role, String prem) {

        //添加雪花主键id
        String roleid= SnowflakeIdWorker.getUUID();
        role.setId(roleid);
        //添加权限
        List<String> prems= ConvertUtil.toListStrArray(prem);
        for (String premid : prems) {
            MemberPermissionRole permissionRole = new MemberPermissionRole(RandomUtil.randomUUID() , roleid, premid);
            memberPermissionRoleMapper.insert(permissionRole);
        }
        return memberRoleMapper.insert(role);
    }

    @Override
    public void deleteMemberRole(String id) {

        MemberRole memberRole = memberRoleMapper.selectByPrimaryKey(id);
        if(memberRole==null){
            throw new MemberRoleIsNullException();
        }
        try{
            memberRoleMapper.deleteByPrimaryKey(id);
            memberPermissionRoleMapper.deleteByRoleId(id);
        }catch (Exception e){
            e.getMessage();
        }
    }
}
