package com.wind.member.service;


import com.github.pagehelper.PageInfo;
import com.wind.member.entity.Member;
import com.wind.member.entity.Tablepar;

import java.util.List;

public interface MemberService {

    void addMember(Member member);

    void deleteMember(Long id);

    void updateMember(Member member);

    PageInfo<Member> findAllUse(Member member, Tablepar tablepar);

    Member findById(Long id);


}
