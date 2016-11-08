package com.example.vincent.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @name Example
 * @class name：com.example.vincent.bean
 * @class describe
 * @anthor Vincent QQ:1032006226
 * @time 2016/11/8 9:36
 * @change
 * @chang time
 * @class describe
 */
@Entity
public class User {
    private String name;
    private String account;
    private String pwd;
    private String age;
    private String sex;
    @Id
    private String id;
    @Generated(hash = 835153384)
    public User(String name, String account, String pwd, String age, String sex,
            String id) {
        this.name = name;
        this.account = account;
        this.pwd = pwd;
        this.age = age;
        this.sex = sex;
        this.id = id;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPwd() {
        return this.pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    private String String(){
        return "name="+name+",account="+account+",age="+age+",sex="+sex;
    }

}
