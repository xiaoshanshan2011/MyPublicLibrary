package com.shan.mypubliclibrary.bean;

/**
 * Created by 大唐天下 on 2016/8/19.
 */

public class PostTestBean {
    /**
     * code : 401
     * message : 访问成功
     * data : {"name":"xiaoshanshan","age":"26","sex":"男","headimage":"hhhhhhhhhhhhhhhh"}
     */

    private int code;
    private String message;
    /**
     * name : xiaoshanshan
     * age : 26
     * sex : 男
     * headimage : hhhhhhhhhhhhhhhh
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String name;
        private String age;
        private String sex;
        private String headimage;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getHeadimage() {
            return headimage;
        }

        public void setHeadimage(String headimage) {
            this.headimage = headimage;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", sex='" + sex + '\'' +
                    ", headimage='" + headimage + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PostTestBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
