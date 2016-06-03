package com.ralph.second;

import java.io.Serializable;

/**
 * Created by 果占先 on 2016/5/11.
 */
public class Student implements Serializable{
    private int _id;
    private int pic;
    private String name;
    private int age;

    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }
    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
