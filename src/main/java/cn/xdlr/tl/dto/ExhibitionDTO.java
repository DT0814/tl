package cn.xdlr.tl.dto;

import cn.xdlr.tl.pojo.User;

import java.util.List;

public class ExhibitionDTO {
    private Integer retCode;

    private Integer userNumber;

    private Integer userOnline;

    private List<User> userList;

    private Integer blockHeight;

    public ExhibitionDTO(Integer retCode, Integer userNumber, Integer userOnline, List<User> userList, Integer blockHeight) {
        this.retCode = retCode;
        this.userNumber = userNumber;
        this.userOnline = userOnline;
        this.userList = userList;
        this.blockHeight = blockHeight;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public Integer getUserOnline() {
        return userOnline;
    }

    public void setUserOnline(Integer userOnline) {
        this.userOnline = userOnline;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public Integer getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(Integer blockHeight) {
        this.blockHeight = blockHeight;
    }

    @Override
    public String toString() {
        return "ExhibitionDTO{" +
                "retCode=" + retCode +
                ", userNumber=" + userNumber +
                ", userOnline=" + userOnline +
                ", userList=" + userList +
                ", blockHeight=" + blockHeight +
                '}';
    }
}
