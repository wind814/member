package com.wind.member.controller;

import com.github.pagehelper.PageInfo;
import com.wind.member.domain.AjaxResult;
import com.wind.member.entity.Member;
import com.wind.member.entity.MemberRecord;
import com.wind.member.entity.TableSplitResult;
import com.wind.member.entity.Tablepar;
import com.wind.member.service.MemberRecordService;
import com.wind.member.service.MemberService;
import com.wind.member.util.EnumUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/v1/memberRecord/")
public class MemberRecordController {

        private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_member_single");

        @Autowired
        private MemberRecordService memberRecordService;

        @Autowired
        private MemberService memberService;

        @RequestMapping(value = "view" ,method = RequestMethod.GET)
        public String findMovieListByStarIdView(ModelMap map,Long memberId,String type){

                map.put("title",EnumUtil.memberRecordOrder.equals(type)?"订单列表":"充值列表");
                map.put("parenttitle","订单管理");
                map.put("isMsg",true);
                map.put("msgHTML","欢迎进入");
                map.put("isControl",true);
                map.put("isribbon", false);
                map.put("memberId", memberId);
                map.put("type", type);
                return "memberRecord/list";
        }

        @RequestMapping(value = "list" ,method = RequestMethod.POST)
        @ResponseBody
        public Object findMovieListByStarId(MemberRecord member, ModelMap map, Tablepar tablepar){

                PageInfo<MemberRecord> pageInfo =  memberRecordService.findAllUse(member,tablepar);

                if(pageInfo.getList()==null){
                        return "0";
                }

                map.put("title",EnumUtil.memberRecordOrder.equals(member.getType())?"订单列表":"充值列表");
                map.put("parenttitle","订单管理");
                map.put("isMsg",true);
                map.put("msgHTML","欢迎进入");
                map.put("isControl",true);
                map.put("isribbon", false);

                return new TableSplitResult<MemberRecord>(pageInfo.getPageNum(),pageInfo.getTotal(),pageInfo.getList());
        }




        @GetMapping("/toAdd")
        public String add(ModelMap map,Long memberId,String type)
        {
                map.put("member",memberService.findById(memberId));
                map.put("type",type);
                return "memberRecord/add";
        }

        @RequestMapping(value = "addMemberRecord" ,method = RequestMethod.POST)
        @ResponseBody
        public AjaxResult addMember(MemberRecord record){
                try{
                        memberRecordService.addMemberRecord(record);
                }catch (Exception e){
                        return AjaxResult.error(e.getMessage());
                }
                return AjaxResult.success();
        }

        @RequestMapping(value = "deleteMemberRecord" ,method = RequestMethod.POST)
        @ResponseBody
        public AjaxResult deleteMember(Long ids){
                try{
                        memberRecordService.deleteMemberRecord(ids);
                }catch (Exception e){
                        return AjaxResult.error(e.getMessage());
                }
                return AjaxResult.success();
        }


}
