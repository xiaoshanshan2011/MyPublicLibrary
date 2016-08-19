package com.shan.mypubliclibrary.bean;

/**
 * Created by 大唐天下 on 2016/8/19.
 */

public class testbean {
    private String name;

    public testbean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "testbean{" +
                "name='" + name + '\'' +
                '}';
    }
}
