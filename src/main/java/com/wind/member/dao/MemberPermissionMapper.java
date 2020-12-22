package com.wind.member.dao;

import com.wind.member.entity.MemberPermission;
import com.wind.member.entity.MemberPermissionRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberPermission record);

    MemberPermission selectByPrimaryKey(String id);

    List<MemberPermission> selectAll();

    int updateByPrimaryKey(MemberPermission record);

    List<MemberPermission> findByRoleId(String id);

    List<MemberPermission> findByRoleIdAsc(String roleId);

    List<MemberPermission> findByAdminUserId(String id);

    List<MemberPermission> findAll(MemberPermission record);
}