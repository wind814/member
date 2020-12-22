package com.wind.member.dao;

import com.wind.member.entity.Member;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberMapper {
    int deleteByPrimaryKey(Long id);

    Long insert(Member record);

    Member selectByPrimaryKey(Long id);

    List<Member> selectAll();

    int updateByPrimaryKey(Member record);

    void updateStateById(@Param("id") Long id,@Param("state") String state);

    void updateByParam(Member record);

    Member selectByIdAndState(@Param("id") Long id,@Param("state") String state);

    List<Member> findAllUse(Member record);

}