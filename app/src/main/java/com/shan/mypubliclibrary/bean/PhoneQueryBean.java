package com.shan.mypubliclibrary.bean;

/**
 * 手机查询Bean
 * Created by 陈俊山 on 2016/8/28.
 */

public class PhoneQueryBean extends BaseBean {

    /**
     * ret_code : 0
     * num : 1342205
     * prov : 广东
     * name : 移动
     * provCode : 440000
     * type : 1
     * city : 广州
     */

    private ShowapiResBodyBean showapi_res_body;

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        private int ret_code;
        private int num;
        private String prov;
        private String name;
        private String provCode;
        private int type;
        private String city;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getProv() {
            return prov;
        }

        public void setProv(String prov) {
            this.prov = prov;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProvCode() {
            return provCode;
        }

        public void setProvCode(String provCode) {
            this.provCode = provCode;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "ShowapiResBodyBean{" +
                    "ret_code=" + ret_code +
                    ", num=" + num +
                    ", prov='" + prov + '\'' +
                    ", name='" + name + '\'' +
                    ", provCode='" + provCode + '\'' +
                    ", type=" + type +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PhoneQueryBean{" +
                "showapi_res_body=" + showapi_res_body +
                '}';
    }
}
