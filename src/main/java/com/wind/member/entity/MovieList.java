package com.wind.member.entity;

import java.io.Serializable;
import java.util.Date;

public class MovieList implements Serializable {
    private Long id;

    private Long starId;

    private String fileSize;

    private String nameCode;

    private Boolean highDefinition;

    private Boolean favorite;

    private String address;

    private Boolean isChinese;

    private Date createAt;

    private Date updateAt;

    private String volume;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStarId() {
        return starId;
    }

    public void setStarId(Long starId) {
        this.starId = starId;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    public String getNameCode() {
        return nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode == null ? null : nameCode.trim();
    }

    public Boolean getHighDefinition() {
        return highDefinition;
    }

    public void setHighDefinition(Boolean highDefinition) {
        this.highDefinition = highDefinition;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsChinese() {
        return isChinese;
    }

    public void setIsChinese(Boolean isChinese) {
        this.isChinese = isChinese;
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

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", starId=").append(starId);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", nameCode=").append(nameCode);
        sb.append(", highDefinition=").append(highDefinition);
        sb.append(", favorite=").append(favorite);
        sb.append(", address=").append(address);
        sb.append(", isChinese=").append(isChinese);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", volume=").append(volume);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}