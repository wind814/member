package com.wind.member.entity;

import java.io.Serializable;
import java.util.Date;

public class MemberOperations implements Serializable {

    public MemberOperations(){}

    public MemberOperations(Long roleId,Long memberId,Long memberRecordId
            ,String operation,String description,Date createAt){

        this.roleId=roleId;
        this.memberId=memberId;
        this.memberRecordId=memberRecordId;
        this.operation=operation;
        this.description=description;
        this.createAt=createAt;

    }


    private Long id;

    private Long roleId;

    private Long memberId;

    private Long memberRecordId;

    private String operation;

    private String description;

    private Date createAt;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMemberRecordId() {
        return memberRecordId;
    }

    public void setMemberRecordId(Long memberRecordId) {
        this.memberRecordId = memberRecordId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", memberId=").append(memberId);
        sb.append(", memberRecordId=").append(memberRecordId);
        sb.append(", operation=").append(operation);
        sb.append(", description=").append(description);
        sb.append(", createAt=").append(createAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}