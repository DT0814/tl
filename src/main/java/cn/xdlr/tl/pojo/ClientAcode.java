package cn.xdlr.tl.pojo;

import cn.xdlr.tl.utils.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "client_acode")
public class ClientAcode {
    @Id
    private Integer cid;
    private String acode;
    private Date time;

    @Override
    public String toString() {
        return "ClientAcode{" +
                "cid=" + cid +
                ", acode='" + acode + '\'' +
                ", time=" + time +
                '}';
    }

    public ClientAcode() {
    }

    public ClientAcode(int cid, String acode, Date time) {
        this.cid = cid;
        this.acode = acode;
        this.time = time;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getAcode() {
        return acode;
    }

    public void setAcode(String acode) {
        this.acode = acode;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
