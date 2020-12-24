package com.wind.member.exception;

public class MemberRoleIsNullException extends RuntimeException{

    @Override
    public String getMessage() {
        return " memberRole is null so .....";
    }
}
