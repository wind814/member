package com.wind.member.exception;

public class NotEnoughMoneyException extends RuntimeException{

    private String money;

    private String orderMoney;

    public NotEnoughMoneyException(String money,String orderMoney){
        this.money = money;
        this.orderMoney = orderMoney;
    }

    public String getMessage() {
        return " 当前用户余额："+money+",此次消费金额："+orderMoney+",余额不足，请先充值！！！";
    }
}
