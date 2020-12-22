package com.wind.member.exception;

public class MemberTelephoneExistException extends RuntimeException{

    @Override
    public String getMessage() {
        return " 已经存在使用此电话号码得会员 ！";
    }
}
