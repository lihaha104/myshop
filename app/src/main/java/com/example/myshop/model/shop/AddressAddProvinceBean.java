package com.example.myshop.model.shop;

import java.util.List;

public class AddressAddProvinceBean {

    /**
     * errno : 0
     * errmsg :
     * data : [{"id":2,"parent_id":1,"name":"北京","type":1,"agency_id":0},{"id":3,"parent_id":1,"name":"天津","type":1,"agency_id":0},{"id":4,"parent_id":1,"name":"河北省","type":1,"agency_id":0},{"id":5,"parent_id":1,"name":"山西省","type":1,"agency_id":0},{"id":6,"parent_id":1,"name":"内蒙古自治区","type":1,"agency_id":0},{"id":7,"parent_id":1,"name":"辽宁省","type":1,"agency_id":0},{"id":8,"parent_id":1,"name":"吉林省","type":1,"agency_id":0},{"id":9,"parent_id":1,"name":"黑龙江省","type":1,"agency_id":0},{"id":10,"parent_id":1,"name":"上海","type":1,"agency_id":0},{"id":11,"parent_id":1,"name":"江苏省","type":1,"agency_id":0},{"id":12,"parent_id":1,"name":"浙江省","type":1,"agency_id":0},{"id":13,"parent_id":1,"name":"安徽省","type":1,"agency_id":0},{"id":14,"parent_id":1,"name":"福建省","type":1,"agency_id":0},{"id":15,"parent_id":1,"name":"江西省","type":1,"agency_id":0},{"id":16,"parent_id":1,"name":"山东省","type":1,"agency_id":0},{"id":17,"parent_id":1,"name":"河南省","type":1,"agency_id":0},{"id":18,"parent_id":1,"name":"湖北省","type":1,"agency_id":0},{"id":19,"parent_id":1,"name":"湖南省","type":1,"agency_id":0},{"id":20,"parent_id":1,"name":"广东省","type":1,"agency_id":0},{"id":21,"parent_id":1,"name":"广西壮族自治区","type":1,"agency_id":0},{"id":22,"parent_id":1,"name":"海南省","type":1,"agency_id":0},{"id":23,"parent_id":1,"name":"重庆","type":1,"agency_id":0},{"id":24,"parent_id":1,"name":"四川省","type":1,"agency_id":0},{"id":25,"parent_id":1,"name":"贵州省","type":1,"agency_id":0},{"id":26,"parent_id":1,"name":"云南省","type":1,"agency_id":0},{"id":27,"parent_id":1,"name":"西藏自治区","type":1,"agency_id":0},{"id":28,"parent_id":1,"name":"陕西省","type":1,"agency_id":0},{"id":29,"parent_id":1,"name":"甘肃省","type":1,"agency_id":0},{"id":30,"parent_id":1,"name":"青海省","type":1,"agency_id":0},{"id":31,"parent_id":1,"name":"宁夏回族自治区","type":1,"agency_id":0},{"id":32,"parent_id":1,"name":"新疆维吾尔自治区","type":1,"agency_id":0},{"id":33,"parent_id":1,"name":"台湾","type":1,"agency_id":0},{"id":34,"parent_id":1,"name":"香港特别行政区","type":1,"agency_id":0},{"id":35,"parent_id":1,"name":"澳门特别行政区","type":1,"agency_id":0},{"id":36,"parent_id":1,"name":"海外","type":1,"agency_id":0}]
     */

    private int errno;
    private String errmsg;
    private List<DataBean> data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * parent_id : 1
         * name : 北京
         * type : 1
         * agency_id : 0
         */

        private int id;
        private int parent_id;
        private String name;
        private int type;
        private int agency_id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getAgency_id() {
            return agency_id;
        }

        public void setAgency_id(int agency_id) {
            this.agency_id = agency_id;
        }
    }
}
