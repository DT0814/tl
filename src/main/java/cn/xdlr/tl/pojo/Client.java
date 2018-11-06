package cn.xdlr.tl.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tl_client")
public class Client {
    @Id
    @GeneratedValue
    private int cid;
    private String pass;
    private String info;
    public Client() {
    }

    public Client(String pass, String info) {
        this.pass = pass;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cid=" + cid +
                ", pass='" + pass + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
