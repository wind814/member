package com.wind.member.service;


import com.wind.member.BootstrapTree;

public interface LoginService {

    BootstrapTree getBootstrapTree();

    BootstrapTree getBootstrapTreePerm(String userid);
}
