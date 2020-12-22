package com.wind.member.dao;

import com.wind.member.entity.MemberRecord;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberRecord record);

    MemberRecord selectByPrimaryKey(Long id);

    List<MemberRecord> selectAll();

    int updateByPrimaryKey(MemberRecord record);

    MemberRecord selectByIdAndState(@Param("id") Long id, @Param("state") String state);

    void updateStateById(@Param("id") Long id,@Param("state") String state);

    List<MemberRecord> findAllUse(MemberRecord record);
}