package com.wind.member.dao;

import com.wind.member.entity.MemberOperations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberOperationsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberOperations record);

    MemberOperations selectByPrimaryKey(Long id);

    List<MemberOperations> selectAll();

    int updateByPrimaryKey(MemberOperations record);
}