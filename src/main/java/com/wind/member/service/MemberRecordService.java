package com.wind.member.service;


import com.github.pagehelper.PageInfo;
import com.wind.member.entity.MemberRecord;
import com.wind.member.entity.Tablepar;

public interface MemberRecordService {

    void addMemberRecord(MemberRecord memberRecord);

    void deleteMemberRecord(Long id);

    PageInfo<MemberRecord> findAllUse(MemberRecord memberRecord, Tablepar tablepar);

}
