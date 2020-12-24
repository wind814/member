package com.wind.member.dao;

import com.wind.member.entity.MemberRoleUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberRoleUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberRoleUser record);

    MemberRoleUser selectByPrimaryKey(String id);

    List<MemberRoleUser> selectAll();

    int updateByPrimaryKey(MemberRoleUser record);

    void deleteByUserId(String id);
}