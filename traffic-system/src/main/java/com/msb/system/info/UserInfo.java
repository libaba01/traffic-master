package com.msb.system.info;


import javax.persistence.*;

//和数据库中的表交互的实体类
@Entity
@Table(name="t_user")  //当前类和表产生关联
public class UserInfo {

    @Id  //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增长
    private long uid;

    @Column(name="uname")  //名字匹配数据库表字段
    private String uname;

    @Column
    private String uaccount;
    @Column
    private String upass;
    @Column
    private String umail;
    @Column
    private String uphone;
    @Column
    private String remark;
    @Column
    private int ustatus;

    public int getUstatus() {
        return ustatus;
    }

    public void setUstatus(int ustatus) {
        this.ustatus = ustatus;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }


    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }


    public String getUmail() {
        return umail;
    }

    public void setUmail(String umail) {
        this.umail = umail;
    }


    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
