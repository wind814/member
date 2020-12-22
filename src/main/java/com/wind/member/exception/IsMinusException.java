package com.wind.member.exception;

public class IsMinusException extends RuntimeException{

    private String money;

    public IsMinusException(String money){
        this.money = money;
    }

    public String getMessage() {
        return " 输入金额: "+money+", 金额不能小于等于0 ";
    }
}
