package com.wind.member.service;


import com.github.pagehelper.PageInfo;
import com.wind.member.entity.MemberPermission;
import com.wind.member.entity.Tablepar;

import java.util.List;

public interface MemberPermissionService {

    PageInfo<MemberPermission> findAll(MemberPermission memberPermission, Tablepar tablepar);

    List<MemberPermission> findAll(MemberPermission memberPermission);

}
