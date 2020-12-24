package com.wind.member.service;


import com.github.pagehelper.PageInfo;
import com.wind.member.entity.MemberUser;
import com.wind.member.entity.Tablepar;

import java.util.List;

public interface MemberUserService {

    PageInfo<MemberUser> findAll(MemberUser user, Tablepar tablepar);

    List<MemberUser> findAll(MemberUser user);

    void deleteMemberUser(String id);

    int addMemberUser(MemberUser user,List<String> roles);
}
