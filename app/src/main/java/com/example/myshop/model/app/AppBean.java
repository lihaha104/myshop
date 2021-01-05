package com.example.myshop.model.app;

import java.util.List;

public class AppBean {

    /**
     * errno : 0
     * errmsg :
     * data : [{"id":1,"name":"1","size":1,"url":"1","version":"1","vcode":1,"desc":"1","uid":"85323a42-ae1c-4901-b3ac-0b513e3964d7"}]
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
         * id : 1
         * name : 1
         * size : 1
         * url : 1
         * version : 1
         * vcode : 1
         * desc : 1
         * uid : 85323a42-ae1c-4901-b3ac-0b513e3964d7
         */

        private int id;
        private String name;
        private int size;
        private String url;
        private String version;
        private int vcode;
        private String desc;
        private String uid;

        public String getPg() {
            return pg;
        }

        public void setPg(String pg) {
            this.pg = pg;
        }

        private String pg;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public int getVcode() {
            return vcode;
        }

        public void setVcode(int vcode) {
            this.vcode = vcode;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
