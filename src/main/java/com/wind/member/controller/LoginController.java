package com.wind.member.controller;

import com.wind.member.BootstrapTree;
import com.wind.member.config.V2Config;
import com.wind.member.domain.AjaxResult;
import com.wind.member.entity.MemberUser;
import com.wind.member.service.LoginService;
import com.wind.member.shiro.util.ShiroUtils;
import com.wind.member.shiro.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import com.google.code.kaptcha.Constants;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
@RequestMapping("/v1/member/login/")
public class LoginController {

        private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

        private static final Logger wind0415Single = LoggerFactory.getLogger("wind_0415_single");

        @Autowired
        private LoginService loginService;


        @GetMapping("/index")
        public String index(HttpServletRequest request) {

            //获取菜单栏
            BootstrapTree bootstrapTree= loginService.getBootstrapTreePerm(ShiroUtils.getUserId());
            request.getSession().setAttribute("bootstrapTree", bootstrapTree);
            request.getSession().setAttribute("sessionUserName",ShiroUtils.getUser().getNickname());
            //获取公告信息
//            List<SysNotice> notices=sysNoticeService.getuserNoticeNotRead(ShiroUtils.getUser(),0);
//            request.getSession().setAttribute("notices",notices);notices
//            request.getSession().setAttribute("bootstrapTree",loginService.getBootstrapTree());
            request.getSession().setAttribute("notices",new ArrayList<>());
            return "admin/index";
        }

        @GetMapping("login")
        public String login(ModelMap modelMap) {
            try {
                if ((null != SecurityUtils.getSubject() && SecurityUtils.getSubject().isAuthenticated()) || SecurityUtils.getSubject().isRemembered()) {
                    return "redirect:/v1/member/login/index";
                }else {
                    System.out.println("--进行登录验证..验证开始");
                    modelMap.put("RollVerification", V2Config.getRollVerification());
                    return "login";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "login";
        }

        @PostMapping("login")
        @ResponseBody
        public AjaxResult login(MemberUser memberUser,HttpServletRequest request, String code) {

            Boolean yz;
            if(V2Config.getRollVerification()) {//滚动验证
                yz=true;
            }else {//图片验证
                String scode = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
                yz= StringUtils.isNotEmpty(scode)&&StringUtils.isNotEmpty(code)&&scode.equals(code);
            }

            if(yz){
                Subject currentUser = SecurityUtils.getSubject();
                if(!currentUser.isAuthenticated()) {
                    //是否验证通过
                    UsernamePasswordToken token = new UsernamePasswordToken(memberUser.getUsername(), memberUser.getPassword());
                    try {
                        //存入用户
                        currentUser.login(token);
                        if (ShiroUtils.getUser() != null) {
                            //跳转到 get请求的登陆方法
                            //view.setViewName("redirect:/"+prefix+"/index");
                            return AjaxResult.success();
                        } else {
                            return AjaxResult.error(500, "未知账户");
                        }
                    } catch (UnknownAccountException uae) {
                        logger.info("对用户[" + memberUser.getUsername() + "]进行登录验证..验证未通过,未知账户");
                        return AjaxResult.error(500, "未知账户");
                    } catch (IncorrectCredentialsException ice) {
                        logger.info("对用户[" + memberUser.getUsername() + "]进行登录验证..验证未通过,错误的凭证");
                        return AjaxResult.error(500, "用户名或密码不正确");
                    } catch (LockedAccountException lae) {
                        logger.info("对用户[" + memberUser.getUsername() + "]进行登录验证..验证未通过,账户已锁定");
                        return AjaxResult.error(500, "账户已锁定");
                    } catch (ExcessiveAttemptsException eae) {
                        logger.info("对用户[" + memberUser.getUsername() + "]进行登录验证..验证未通过,错误次数过多");
                        return AjaxResult.error(500, "用户名或密码错误次数过多");
                    } catch (AuthenticationException ae) {
                        //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
                        logger.info("对用户[" + memberUser.getUsername() + "]进行登录验证..验证未通过,堆栈轨迹如下");
                        ae.printStackTrace();
                        return AjaxResult.error(500, "用户名或密码不正确");
                    }

                }else {
                    if(StringUtils.isNotNull(ShiroUtils.getUser())) {
                        return  AjaxResult.success();
                    }else {
                        return  AjaxResult.error(500,"未知账户");
                    }
                }
            }else {
                return AjaxResult.error(500,"验证码不正确!");
            }
        }

//        @ApiOperation(value="退出登陆",notes="退出登陆")
        @GetMapping("LoginOut")
        public String LoginOut(HttpServletRequest request, HttpServletResponse response){
            //在这里执行退出系统前需要清空的数据
            Subject subject = SecurityUtils.getSubject();
            //注销
            subject.logout();
            return "redirect:/v1/member/login/login";
        }

        @GetMapping("/main")
        public String main(ModelMap map) {
//            setTitle(map, new TitleVo("首页", "首页", true,"欢迎进入", true, false));
            return "member/main";
        }
}
