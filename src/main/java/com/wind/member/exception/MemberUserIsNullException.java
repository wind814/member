package com.wind.member.exception;

public class MemberUserIsNullException extends RuntimeException{

    @Override
    public String getMessage() {
        return " memberUser is null so .....";
    }
}
