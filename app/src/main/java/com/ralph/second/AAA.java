package com.ralph.second;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Created by 果占先 on 2016/5/11.
 */
public class AAA {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("张三");
        s.setAge(22);

        try {
            OutputStream os = new FileOutputStream("d:/aaa.bin");
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
