package com.client.bean;

import java.util.List;

public class GetRoomListBean {

    /**
     * errno : 0
     * errmsg :
     * data : [{"id":1,"name":"666的房间","owner":"85323a42-ae1c-4901-b3ac-0b513e3964d7","isopen":1,"status":1,"date":1609729449,"title":"直播","icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":2,"name":"会玩的房间","owner":"7b965656-70eb-4726-b4a7-c52366861485","isopen":1,"status":1,"date":1609740654,"title":"教你会玩","icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":3,"name":"狂浪生","owner":"f4718973-0a02-4f6b-aa9a-19a22d9aa9ad","isopen":1,"status":1,"date":1609740680,"title":"狂浪生","icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":4,"name":"倩女幽魂的直播间","owner":"3582cac9-d6ba-45db-ab08-024434737f52","isopen":1,"status":1,"date":1609740686,"title":"直播","icon":"www.xxxxx"},{"id":5,"name":"小白的直播间","owner":"1f2cecff-1e45-45d1-ad38-0a6ee97b43e4","isopen":1,"status":null,"date":1609741082,"title":null,"icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":6,"name":"小白的直播间","owner":"ece54afb-019a-403d-ba22-b287d7da9563","isopen":1,"status":1,"date":1609741103,"title":"直播","icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":7,"name":"迪丽热巴的房间","owner":"03c05564-8025-4e66-ab90-fa0289aab3cc","isopen":1,"status":1,"date":1609741142,"title":"直播","icon":"http://image.qianye88.com/pic/f077bb6fb82cf24576f6053bbc0a6c1c?imageMogr2/thumbnail/x280/quality/90!"},{"id":8,"name":"小白的直播间","owner":"0a8fb12b-db64-4277-808a-37d7d713c071","isopen":1,"status":null,"date":1609741144,"title":null,"icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":9,"name":"小白的直播间","owner":"638da211-92d6-4393-a902-779f902dc079","isopen":1,"status":1,"date":1609741330,"title":"小白的直播间","icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":10,"name":"二驴的直播间","owner":"bcf4c089-c447-4150-8235-8fee1506ba17","isopen":1,"status":1,"date":1609741571,"title":"直播","icon":"www.xxxxx"},{"id":11,"name":"小白的直播间","owner":"d58b0f8a-8e7c-4e9a-8798-1962e0794c83","isopen":1,"status":null,"date":1609741790,"title":null,"icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":12,"name":"微微笑 的房间","owner":"a5e51654-ee70-4120-8a8a-d87df0ee7327","isopen":1,"status":1,"date":1609741994,"title":"户外直播","icon":"http://yanxuan.nosdn.127.net/7335f6e807e8507994710bca848de2d8.jpg"},{"id":13,"name":"刘玥的直播间","owner":"0c940339-b032-4a21-b641-f89657274cea","isopen":1,"status":1,"date":1609742633,"title":"刘玥的直播间","icon":"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic1.zhimg.com%2F50%2Fv2-6c2f1c6ac64f5a39e816196d609eec8a_hd.jpg&refer=http%3A%2F%2Fpic1.zhimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612407224&t=791ed50cab81be68432e516f732974bc"},{"id":14,"name":"cc直播","owner":"f0445d3e-44af-47ff-93c2-333e1355f895","isopen":1,"status":1,"date":1609744333,"title":"直播","icon":"http://2002aaa.oss-cn-beijing.aliyuncs.com/1609669349592.jpg"},{"id":15,"name":"易先生的直播间","owner":"a3ef976a-50db-496c-8242-6bf582afc3dc","isopen":1,"status":1,"date":1609744546,"title":"易先生的直播间","icon":"http://2002aaa.oss-cn-beijing.aliyuncs.com/1609741943984.jpg"},{"id":16,"name":"小白的直播间22","owner":"4551c4cd-a841-444f-a16e-3a804120a339","isopen":1,"status":null,"date":1609746107,"title":null,"icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":17,"name":"陈sir的闺房","owner":"ac64c3e1-6bbe-4ed8-b315-280eefd7d7be","isopen":1,"status":1,"date":1609751223,"title":"直播","icon":"www"},{"id":18,"name":"惊悚直播","owner":"73404f8b-bf50-4bc1-a77a-942edca41272","isopen":1,"status":1,"date":1609757032,"title":"直播","icon":"www.xxxxx"},{"id":19,"name":"小","owner":"97c3b73f-15ec-412e-b750-48c65d5d56b4","isopen":1,"status":1,"date":1609757237,"title":"小","icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":20,"name":"小孙的直播间","owner":"267a1806-ff7f-4b36-982e-e0020cf08910","isopen":1,"status":1,"date":1609758114,"title":"直播","icon":"https://2002aa.oss-cn-beijing.aliyuncs.com/1609243608806.jpg"},{"id":21,"name":"大能的房间","owner":"604860aa-805f-4dca-a75c-2c1255eb4c53","isopen":1,"status":1,"date":1609758449,"title":"直播","icon":"www.xxxxx"},{"id":22,"name":"小浩林的直播间","owner":"d2b92034-69cc-47c6-9acf-73cb755f60e0","isopen":1,"status":null,"date":1609760768,"title":null,"icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":23,"name":"小雨的房间","owner":"a3ea9557-ed27-4780-89e6-18831f2b9816","isopen":1,"status":null,"date":1609813615,"title":"户外直播","icon":"www.xxxxx"},{"id":24,"name":"孙宇航吃香香的房间","owner":"d6ded0af-8259-4a5c-94d4-f1dc6a8d4aab","isopen":1,"status":1,"date":1609816227,"title":"直播","icon":"www.xxxxx"},{"id":25,"name":"超级惊簌直播间","owner":"c3362a79-1603-4ce9-b6ac-e8132977002b","isopen":1,"status":null,"date":1609817007,"title":null,"icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":26,"name":"yb的直播间","owner":"009616f7-1b35-4ef2-b02b-135ca435dbe3","isopen":1,"status":1,"date":1609832065,"title":"直播","icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"},{"id":27,"name":"小白的直播间","owner":"08d725b9-0363-47e4-b381-249feceb29f9","isopen":1,"status":null,"date":1609833606,"title":null,"icon":"https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg"}]
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
         * name : 666的房间
         * owner : 85323a42-ae1c-4901-b3ac-0b513e3964d7
         * isopen : 1
         * status : 1
         * date : 1609729449
         * title : 直播
         * icon : https://shop-app1.oss-cn-beijing.aliyuncs.com/live/1/room.jpg
         */

        private int id;
        private String name;
        private String owner;
        private int isopen;
        private int status;
        private int date;
        private String title;
        private String icon;

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

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public int getIsopen() {
            return isopen;
        }

        public void setIsopen(int isopen) {
            this.isopen = isopen;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
