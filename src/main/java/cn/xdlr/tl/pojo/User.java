package cn.xdlr.tl.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tl_user")
public class User {
    @Id
    private Integer uid;
    private String uinfo;
    private Integer value;
    private String name;
    private Integer age;

    public User() {
    }

    public User(String uinfo, Integer value) {
        this.uinfo = uinfo;
        this.value = value;
    }

    public User(Integer uid, String uinfo) {
        this.uid = uid;
        this.uinfo = uinfo;
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

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uinfo='" + uinfo + '\'' +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
