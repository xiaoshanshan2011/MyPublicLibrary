package com.shan.mypubliclibrary.bean;

/**
 * Created by 陈俊山 on 2016/7/27.
 */

public class GetStudentBean {

    /**
     * code : 401
     * message : 访问成功
     * data : {"name":"xiaoshanshan","userid":"11111111111111111111","age":"26","sex":"男","headimage":"http://img1.imgtn.bdimg.com/it/u=2618987948,1808310603&fm=206&gp=0.jpg"}
     */

    private int code;
    private String message;
    /**
     * name : xiaoshanshan
     * userid : 11111111111111111111
     * age : 26
     * sex : 男
     * headimage : http://img1.imgtn.bdimg.com/it/u=2618987948,1808310603&fm=206&gp=0.jpg
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
        private String userid;
        private String age;
        private String sex;
        private String headimage;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
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
                    ", userid='" + userid + '\'' +
                    ", age='" + age + '\'' +
                    ", sex='" + sex + '\'' +
                    ", headimage='" + headimage + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GetStudentBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
