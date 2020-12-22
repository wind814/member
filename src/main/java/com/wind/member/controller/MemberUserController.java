package com.wind.member.controller;

import com.github.pagehelper.PageInfo;
import com.wind.member.base.BaseController;
import com.wind.member.entity.MemberPermission;
import com.wind.member.entity.MemberRecord;
import com.wind.member.entity.MemberUser;
import com.wind.member.entity.TableSplitResult;
import com.wind.member.entity.Tablepar;
import com.wind.member.service.MemberUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/member/user")
public class MemberUserController extends BaseController {

	@Autowired
	private MemberUserService memberUserService;
	
	@GetMapping("/view")
    public String view(ModelMap model)
    {	
		String str="用户";
		setTitle(model, "列表", str+"管理", true,"欢迎进入"+str+"页面", true, false);
        return "user/list";
    }
	
	@PostMapping("/list")
	@ResponseBody
	public Object list(MemberUser user, Tablepar tablepar){
		PageInfo<MemberUser> pageInfo = memberUserService.findAll(user,tablepar) ;
		return  new TableSplitResult<MemberUser>(pageInfo.getPageNum(),pageInfo.getTotal(),pageInfo.getList());
	}
}
