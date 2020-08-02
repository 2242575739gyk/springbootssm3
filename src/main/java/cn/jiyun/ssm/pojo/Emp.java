package cn.jiyun.ssm.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "emp")
public class Emp {
    @Id
    private  Integer eid;
    private  String ename;
    private  String job;
    private  String age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  birthday;
    private  String photo;
    private  Integer did;
    private  Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", age='" + age + '\'' +
                ", birthday=" + birthday +
                ", photo='" + photo + '\'' +
                ", did=" + did +
                ", dept=" + dept +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
