package com.wind.member.service.impl;

import com.wind.member.BootstrapTree;
import com.wind.member.dao.MemberPermissionMapper;
import com.wind.member.dao.MemberPermissionRoleMapper;
import com.wind.member.entity.MemberPermission;
import com.wind.member.service.LoginService;
import com.wind.member.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger windMovieSingle = LoggerFactory.getLogger("wind_movie_single");

    @Autowired
    private MemberPermissionMapper memberPermissionMapper;

    @Override
    public BootstrapTree getBootstrapTreePerm(String userid) {
        List<BootstrapTree> treeList = new ArrayList<BootstrapTree>();
        List<MemberPermission> menuList =  getall(userid);
        treeList = getBootstrapTreePerm(menuList,"0");
        if(treeList!=null&&treeList.size()==1) {
            return treeList.get(0);
        }
        return new BootstrapTree("菜单", "fa fa-home", "", "-1","###",0,treeList,"",0);
    }

    public List<MemberPermission> getall(String userid){
        if(StringUtils.isEmpty(userid)) {
            return  memberPermissionMapper.findByRoleIdAsc(userid);
        }
        return  memberPermissionMapper.findByAdminUserId(userid);
    }

    private static List<BootstrapTree> getBootstrapTreePerm(List<MemberPermission> menuList, String parentId){
        List<BootstrapTree> treeList = new ArrayList<>();
        List<BootstrapTree> childList = null;
        for(MemberPermission p : menuList) {
            p.setPid(p.getPid()==null||p.getPid().trim().equals("")?"0":p.getPid());
            if(p.getPid().trim().equals(parentId)) {
                if(p.getChildCount()!=null&&p.getChildCount()>0) {
                    childList = getBootstrapTreePerm(menuList, String.valueOf(p.getId()));
                }
                BootstrapTree bootstrapTree = new BootstrapTree(p.getName(), p.getIcon(), "", String.valueOf(p.getId()), p.getUrl(),p.getIsBlank(),childList,p.getPerms(),p.getVisible());
                treeList.add(bootstrapTree);
                childList = null;
            }
        }
        return treeList.size() >0 ? treeList : null;
    }
}
