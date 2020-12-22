package com.wind.member.exception;

public class MemberIsNullException extends RuntimeException{

    @Override
    public String getMessage() {
        return " member is null so .....";
    }
}
