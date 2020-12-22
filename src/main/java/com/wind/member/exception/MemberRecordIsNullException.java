package com.wind.member.exception;

public class MemberRecordIsNullException extends RuntimeException{

    @Override
    public String getMessage() {
        return " member record is null so .....";
    }
}
