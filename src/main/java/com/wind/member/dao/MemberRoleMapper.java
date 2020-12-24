package com.wind.member.dao;

import com.wind.member.entity.MemberRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberRole record);

    MemberRole selectByPrimaryKey(String id);

    List<MemberRole> selectAll();

    int updateByPrimaryKey(MemberRole record);

    List<MemberRole> findByUserId(String id);

    List<MemberRole> findAll(MemberRole record);
}