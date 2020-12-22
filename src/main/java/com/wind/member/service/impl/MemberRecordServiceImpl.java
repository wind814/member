package com.wind.member.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wind.member.dao.MemberMapper;
import com.wind.member.dao.MemberOperationsMapper;
import com.wind.member.dao.MemberRecordMapper;
import com.wind.member.entity.Member;
import com.wind.member.entity.MemberOperations;
import com.wind.member.entity.MemberRecord;
import com.wind.member.entity.Tablepar;
import com.wind.member.exception.IsMinusException;
import com.wind.member.exception.MemberIsNullException;
import com.wind.member.exception.MemberRecordIsNullException;
import com.wind.member.exception.NotEnoughMoneyException;
import com.wind.member.service.MemberRecordService;
import com.wind.member.service.MemberService;
import com.wind.member.util.EnumUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberRecordServiceImpl implements MemberRecordService {

    private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_movie_single");

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberRecordMapper memberRecordMapper;

    @Autowired
    private MemberOperationsMapper memberOperationsMapper;

    @Override
    public void addMemberRecord(MemberRecord record) {


        //校验member是否存在
        Member member = memberMapper.selectByIdAndState(record.getMemberId(),EnumUtil.stateUse);
        if(member==null){
            throw new MemberIsNullException();
        }

        windMovieSingle.debug("Start add memberRecord member_name: "+member.getName()+" member_telephone: "+member.getTelephone());

        //金额不能小于等于0
        if(record.getMoney().compareTo(new BigDecimal(0))<0){
            throw new IsMinusException(record.getMoney().toString());
        }

        //校验进行  进行增加、删减操作。
        if(EnumUtil.memberRecordOrder.equals(record.getType())){
            //余额不足
            if(member.getMoney().compareTo(record.getMoney())<0 ){
                throw new NotEnoughMoneyException(member.getMoney().toString(),record.getMoney().toString());
            }
            //减少
            member.setMoney(member.getMoney().subtract(record.getMoney()));
        }else {
            //增加
            member.setMoney(member.getMoney().add(record.getMoney()));
        }

        //新增memberRecord
        record.setMemberName(member.getName());
        record.setCreateAt(new Date());
        record.setState(EnumUtil.stateUse);
        memberRecordMapper.insert(record);


        //更新member余额信息
        memberMapper.updateByPrimaryKey(member);

        //新增操作记录
        record = memberRecordMapper.selectByPrimaryKey(record.getId());
        record.setCreateAt(null);
        record.setTelephone(member.getTelephone());
        MemberOperations memberOperations = new MemberOperations(1L,record.getMemberId(),record.getId()
                , EnumUtil.memberRecordOrder.equals(record.getType())?
                EnumUtil.memberRecordAddOrder:EnumUtil.memberRecordAddStore
                ,JSON.toJSONString(record),new Date());
        memberOperationsMapper.insert(memberOperations);

        windMovieSingle.debug("End add memberRecord member_name: "+member.getName()+" member_telephone: "+member.getTelephone());

    }

    @Override
    public void deleteMemberRecord(Long id){

            windMovieSingle.debug("Start delete memberRecord member_id: "+id);

            MemberRecord record = memberRecordMapper.selectByIdAndState(id,EnumUtil.stateUse);
            if(record==null){
                throw new MemberRecordIsNullException();
            }

            //修改状态 逻辑删除
            memberRecordMapper.updateStateById(id,EnumUtil.stateDelete);

            record.setCreateAt(null);
            MemberOperations memberOperations = new MemberOperations(1L,record.getMemberId(),record.getId()
                    , EnumUtil.memberRecordDelete,JSON.toJSONString(record),new Date());
            memberOperationsMapper.insert(memberOperations);

            windMovieSingle.debug("End delete memberRecord member_id: "+id);

    }

    @Override
    public PageInfo<MemberRecord> findAllUse(MemberRecord member, Tablepar tablepar) {

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<MemberRecord> list= memberRecordMapper.findAllUse(member);
        PageInfo<MemberRecord> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}
