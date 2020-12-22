package com.wind.member.dao;

import com.wind.member.entity.MemberUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberUser record);

    MemberUser selectByPrimaryKey(String id);

    List<MemberUser> selectAll();

    int updateByPrimaryKey(MemberUser record);

    MemberUser findByUserName(String userName);

    List<MemberUser> findAll(MemberUser record);
}