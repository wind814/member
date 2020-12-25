package com.wind.member.controller;

import com.github.pagehelper.PageInfo;
import com.wind.member.base.BaseController;
import com.wind.member.domain.AjaxResult;
import com.wind.member.entity.MemberRole;
import com.wind.member.entity.TableSplitResult;
import com.wind.member.entity.Tablepar;
import com.wind.member.service.MemberRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/member/role")
public class MemberRoleController extends BaseController {

	@Autowired
	private MemberRoleService memberRoleService;
	
	@GetMapping("/view")
    public String view(ModelMap model)
    {	
		String str="用户";
		setTitle(model, "列表", str+"管理", true,"欢迎进入"+str+"页面", true, false);
        return "role/list";
    }
	
	@PostMapping("/list")
	@ResponseBody
	public Object list(MemberRole role, Tablepar tablepar){
		PageInfo<MemberRole> pageInfo = memberRoleService.findAll(role,tablepar) ;
		return  new TableSplitResult<>(pageInfo.getPageNum(),pageInfo.getTotal(),pageInfo.getList());
	}


	@GetMapping("/toAdd")
	public String add()
	{
		return "role/add";
	}

	@ResponseBody
	@RequestMapping(value = "/addMemberRole" ,method = RequestMethod.POST)
	public AjaxResult addMember(MemberRole role,String prem){
		try{
			memberRoleService.addMemberRole(role,prem);
		}catch (Exception e){
			return AjaxResult.error(e.getMessage());
		}
		return AjaxResult.success();
	}

	@ResponseBody
	@RequestMapping(value = "/deleteMemberRole" ,method = RequestMethod.POST)
	public AjaxResult addMember(String ids){
		try{
			memberRoleService.deleteMemberRole(ids);
		}catch (Exception e){
			return AjaxResult.error(e.getMessage());
		}
		return AjaxResult.success();
	}



}
