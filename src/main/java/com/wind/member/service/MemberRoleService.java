package com.wind.member.service;

import com.github.pagehelper.PageInfo;
import com.wind.member.entity.MemberRole;
import com.wind.member.entity.Tablepar;

import java.util.List;

public interface MemberRoleService {

    PageInfo<MemberRole> findAll(MemberRole role, Tablepar tablepar);

    List<MemberRole> findAll(MemberRole role);

    int addMemberRole(MemberRole role,String prem);

    void deleteMemberRole(String id);

}
