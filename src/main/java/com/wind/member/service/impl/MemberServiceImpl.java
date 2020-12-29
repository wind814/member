package com.wind.member.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wind.member.dao.MemberMapper;
import com.wind.member.dao.MemberOperationsMapper;
import com.wind.member.entity.Member;
import com.wind.member.entity.MemberOperations;
import com.wind.member.entity.MemberUser;
import com.wind.member.entity.Tablepar;
import com.wind.member.exception.MemberIsNullException;
import com.wind.member.exception.MemberTelephoneExistException;
import com.wind.member.service.MemberService;
import com.wind.member.shiro.util.ShiroUtils;
import com.wind.member.util.EnumUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_movie_single");

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberOperationsMapper memberOperationsMapper;

    @Override
    public void addMember(Member member) {


            //校验
            Member checkParam = new Member(member.getTelephone());
            List<Member> memberList = memberMapper.findAllUse(checkParam);

            if(memberList!=null && memberList.size()>0){
                throw  new MemberTelephoneExistException();
            }

            windMovieSingle.debug("Start add member member_name: "+member.getName()+" member_telephone: "+member.getTelephone());

            member.setCreateAt(new Date());
            member.setUpdateAt(new Date());
            member.setState(EnumUtil.stateUse);
            memberMapper.insert(member);

            member.setCreateAt(null);
            member.setUpdateAt(null);

            MemberUser memberUser = ShiroUtils.getUser();
            MemberOperations memberOperations = new MemberOperations(memberUser.getId(),memberUser.getNickname()
                    ,1L,member.getId(),null
                    , EnumUtil.memberAdd,JSON.toJSONString(member),new Date());
            memberOperationsMapper.insert(memberOperations);

            windMovieSingle.debug("End add member member_name: "+member.getName()+" member_telephone: "+member.getTelephone());

    }

    @Override
    public void deleteMember(Long id) {

            windMovieSingle.debug("Start delete member member_id: "+id);

            Member member = memberMapper.selectByPrimaryKey(id);

            if(member==null){
                throw new MemberIsNullException();
            }

            member.setUpdateAt(new Date());
            //修改状态 逻辑删除
            memberMapper.updateStateById(id,EnumUtil.stateDelete);

            member.setUpdateAt(null);
            member.setCreateAt(null);

            MemberUser memberUser = ShiroUtils.getUser();
            MemberOperations memberOperations = new MemberOperations(memberUser.getId(),memberUser.getNickname()
                    ,1L,member.getId(),null
                    , EnumUtil.memberDelete,JSON.toJSONString(member),new Date());
            memberOperationsMapper.insert(memberOperations);

            windMovieSingle.debug("End delete member member_id: "+id);

    }

    @Override
    public void updateMember(Member member) {

            Member checkParam = new Member(member.getId());
            List<Member> memberList = memberMapper.findAllUse(checkParam);

            if(memberList==null || memberList.size()==0){
                throw  new MemberIsNullException();
            }

            windMovieSingle.debug("Start update member member_name: "+member.getName()+" member_telephone: "+member.getTelephone());

            //验证member是否存在
            Member oldMember = memberList.get(0);

            Map<String,Member> memberMap = new HashMap<>();
            oldMember.setUpdateAt(null);
            oldMember.setUpdateAt(null);
            memberMap.put("old",oldMember);

            member.setUpdateAt(new Date());
            //修改状态 逻辑删除
            memberMapper.updateByParam(member);

            Member newMember = memberMapper.selectByPrimaryKey(member.getId());
            newMember.setUpdateAt(null);
            newMember.setCreateAt(null);
            memberMap.put("new",newMember);

            MemberUser memberUser = ShiroUtils.getUser();
            MemberOperations memberOperations = new MemberOperations(memberUser.getId(),memberUser.getNickname(),
                    1L,member.getId(),null
                    , EnumUtil.memberUpdate,JSON.toJSONString(memberMap),new Date());
            memberOperationsMapper.insert(memberOperations);

            windMovieSingle.debug("End update member member_name: "+member.getName()+" member_telephone: "+member.getTelephone());

    }

    @Override
    public PageInfo<Member> findAllUse(Member member, Tablepar tablepar) {

        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
        List<Member> list= memberMapper.findAllUse(member);
        PageInfo<Member> pageInfo = new PageInfo<Member>(list);
        return pageInfo;
    }

    @Override
    public Member findById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }
}
