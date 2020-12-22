package com.wind.member.controller;

import com.github.pagehelper.PageInfo;
import com.wind.member.domain.AjaxResult;
import com.wind.member.entity.Member;
import com.wind.member.entity.TableSplitResult;
import com.wind.member.entity.Tablepar;
import com.wind.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/member/")
public class MemberCenterController {

        private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_member_single");

        @Autowired
        private MemberService memberService;


        @GetMapping("/toAdd")
        public String add()
        {
                return "member/add";
        }

        @ResponseBody
        @RequestMapping(value = "addMember" ,method = RequestMethod.POST)
        public AjaxResult addMember(Member member){
                try{
                        memberService.addMember(member);
                }catch (Exception e){
                        return AjaxResult.error(e.getMessage());
                }
                return AjaxResult.success();
        }

        @ResponseBody
        @RequestMapping(value = "deleteMember" ,method = RequestMethod.POST)
        public AjaxResult deleteMember(Long ids){
                try{
                        memberService.deleteMember(ids);
                }catch (Exception e){
                        return AjaxResult.error(e.getMessage());
                }
                return AjaxResult.success();
        }

        @GetMapping("/toUpdate/{id}")
        public String update(@PathVariable("id") Long id,ModelMap map)
        {
                map.put("member", memberService.findById(id));
                return "member/edit";
        }

        @ResponseBody
        @RequestMapping(value = "updateMember" ,method = RequestMethod.PUT)
        public AjaxResult updateMember(Member member){
                try{
                        memberService.updateMember(member);
                }catch (Exception e){
                        return AjaxResult.error(e.getMessage());
                }
                return AjaxResult.success();
        }


        @RequestMapping(value = "view" ,method = RequestMethod.GET)
        public String findMovieListByStarIdView(ModelMap map){

                map.put("title","会员列表");
                map.put("parenttitle","会员管理");
                map.put("isMsg",true);
                map.put("msgHTML","欢迎进入");
                map.put("isControl",true);
                map.put("isribbon", false);
                return "member/list";
        }

        @RequestMapping(value = "list" ,method = RequestMethod.POST)
        @ResponseBody
        public Object findMovieListByStarId(Member member, ModelMap map, Tablepar tablepar){

                PageInfo<Member> pageInfo =  memberService.findAllUse(member,tablepar);

                if(pageInfo.getList()==null){
                        return "0";
                }

                map.put("title","首页");
                map.put("parenttitle","首页");
                map.put("isMsg",true);
                map.put("msgHTML","欢迎进入");
                map.put("isControl",true);
                map.put("isribbon", false);

                TableSplitResult<Member> pageList = new TableSplitResult<Member>(pageInfo.getPageNum(),pageInfo.getTotal(),pageInfo.getList());

//                return JSON.toJSONString(list);
                return pageList;
        }


}
