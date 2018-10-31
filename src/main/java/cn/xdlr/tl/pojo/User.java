package cn.xdlr.tl.pojo;

import cn.xdlr.tl.utils.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tl_user")
public class User {
    @Id
    private Integer uid;
    private String uinfo;
    private Integer value;
    private String name;
    private Integer age;
    private Date inTime;
    private Date outTime;
    //1入口 2出口 3售货机
    private Integer state;
    private String imgPath;

    public User() {
    }

    public User(Integer uid) {
        this.uid = uid;
    }

    public User(String uinfo, Integer value) {
        this.uinfo = uinfo;
        this.value = value;
    }

    public User(Integer uid, String uinfo) {
        this.uid = uid;
        this.uinfo = uinfo;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getInTime() {
        return inTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getOutTime() {
        return outTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUinfo() {
        return uinfo;
    }

    public void setUinfo(String uinfo) {
        this.uinfo = uinfo;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uinfo='" + uinfo + '\'' +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", state=" + state +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
