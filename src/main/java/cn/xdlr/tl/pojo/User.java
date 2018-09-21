package cn.xdlr.tl.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tl_user")
public class User {
    @Id
    @GeneratedValue
    private Integer uid;
    private String uinfo;
    private Integer value;

    public User() {
    }

    public User(String uinfo, Integer value) {
        this.uinfo = uinfo;
        this.value = value;
    }
    public User(Integer uid,String uinfo) {
        this.uid = uid;
        this.uinfo = uinfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + uid +
                ", uinfo='" + uinfo + '\'' +
                ", value=" + value +
                '}';
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
}
