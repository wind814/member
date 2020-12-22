package com.wind.member.service.impl;

import com.wind.member.BootstrapTree;
import com.wind.member.dao.MemberPermissionMapper;
import com.wind.member.dao.MemberPermissionRoleMapper;
import com.wind.member.dao.MovieStarMapper;
import com.wind.member.entity.MemberPermission;
import com.wind.member.entity.MovieStar;
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
    private MovieStarMapper movieStarMapper;

    @Autowired
    private MemberPermissionRoleMapper memberPermissionRoleMapper;

    @Autowired
    private MemberPermissionMapper memberPermissionMapper;

    /**
     * 3层tree,1层没用，2层显示名称，3层名称关联url
     * @return BootstrapTree
     */
    @Override
    public BootstrapTree getBootstrapTree() {

        BootstrapTree tree  = new BootstrapTree("电影","fa fa-id-badge","1","1"
                ,"#",0,null,"",0);

        List<MovieStar> list = movieStarMapper.selectAll();

        List<BootstrapTree> treeList = new ArrayList<>();

        if(list!=null && list.size()>0){
            for(MovieStar star : list){

                List<BootstrapTree> treeListTest = new ArrayList<BootstrapTree>();
                BootstrapTree treeTest  = new BootstrapTree(star.getName(),"fa fa-id-badge","1"
                        ,Long.toString(star.getId()),"/v1/movie/movieList/view/"+star.getId(),0,null,"",0);

                treeListTest.add(treeTest);

                BootstrapTree treeNode = new BootstrapTree(star.getName(),"fa fa-id-badge","1"
                        ,Long.toString(star.getId()),"/v1/movie/movieList/view",0,treeListTest,"",0);

                treeList.add(treeNode);
            }
        }
        tree.setNodes(treeList);
        return tree;
    }

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
