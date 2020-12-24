package com.wind.member.dao;

import com.wind.member.entity.MemberPermissionRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberPermissionRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberPermissionRole record);

    MemberPermissionRole selectByPrimaryKey(String id);

    List<MemberPermissionRole> selectAll();

    int updateByPrimaryKey(MemberPermissionRole record);

    int deleteByRoleId(String roleId);

}