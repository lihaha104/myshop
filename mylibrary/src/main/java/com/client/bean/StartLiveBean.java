package com.client.bean;

public class StartLiveBean  {

    /**
     * errno : 0
     * errmsg :
     * data : {"id":"2","owner":"7b965656-70eb-4726-b4a7-c52366861485","title":"直播","push_url":"rtmp://livepush.cdwan.cn/shop/7b965656-70eb-4726-b4a7-c52366861485?txSecret=6601dc3441d6d604b9605701d0bf7f99&txTime=5ff4f3ba","play_url":"rtmp://live.cdwan.cn/shop/7b965656-70eb-4726-b4a7-c52366861485?txSecret=6601dc3441d6d604b9605701d0bf7f99&txTime=5ff4f3ba","status":1}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * owner : 7b965656-70eb-4726-b4a7-c52366861485
         * title : 直播
         * push_url : rtmp://livepush.cdwan.cn/shop/7b965656-70eb-4726-b4a7-c52366861485?txSecret=6601dc3441d6d604b9605701d0bf7f99&txTime=5ff4f3ba
         * play_url : rtmp://live.cdwan.cn/shop/7b965656-70eb-4726-b4a7-c52366861485?txSecret=6601dc3441d6d604b9605701d0bf7f99&txTime=5ff4f3ba
         * status : 1
         */

        private String id;
        private String owner;
        private String title;
        private String push_url;
        private String play_url;
        private int status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPush_url() {
            return push_url;
        }

        public void setPush_url(String push_url) {
            this.push_url = push_url;
        }

        public String getPlay_url() {
            return play_url;
        }

        public void setPlay_url(String play_url) {
            this.play_url = play_url;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
