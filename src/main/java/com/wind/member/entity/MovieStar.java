package com.wind.member.entity;

import java.io.Serializable;
import java.util.Date;

public class MovieStar implements Serializable {


    public MovieStar(String name,Long professionType , Boolean favourite,Long searchNum
                    ,Integer num){
        this.name = name;
        this.professionType=professionType;
        this.favourite=favourite;
        this.searchNum=searchNum;
        this.num=num;
    }

    public MovieStar(){}


    private Long id;

    private String name;

    private Long professionType;

    private Boolean favourite;

    private Long searchNum;

    private Integer num;

    private Date createAt;

    private Date updateAt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getProfessionType() {
        return professionType;
    }

    public void setProfessionType(Long professionType) {
        this.professionType = professionType;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public Long getSearchNum() {
        return searchNum;
    }

    public void setSearchNum(Long searchNum) {
        this.searchNum = searchNum;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", professionType=").append(professionType);
        sb.append(", favourite=").append(favourite);
        sb.append(", searchNum=").append(searchNum);
        sb.append(", num=").append(num);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}