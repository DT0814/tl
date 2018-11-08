package cn.xdlr.tl.pojo;

import cn.xdlr.tl.utils.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user_token")
public class UserToken {
    @Id
    @GeneratedValue
    private int id;
    private int value;
    private String uid;
    private String reason;
    private String url;
    private Date time;

    public UserToken() {
    }

    public UserToken(int value, String uid, String reason, String url, Date time) {
        this.value = value;
        this.uid = uid;
        this.reason = reason;
        this.url = url;
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "id=" + id +
                ", value=" + value +
                ", uid=" + uid +
                ", reason='" + reason + '\'' +
                ", url='" + url + '\'' +
                ", time=" + time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
