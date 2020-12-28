package com.example.myshop.model.topic;

public class TopicDetailBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"id":314,"title":"关爱他成长的每一个足迹","content":"<img src=\"//yanxuan.nosdn.127.net/75c55a13fde5eb2bc2dd6813b4c565cc.jpg\">\n    <img src=\"//yanxuan.nosdn.127.net/e27e1de2b271a28a21c10213b9df7e95.jpg\">\n    <img src=\"//yanxuan.nosdn.127.net/9d413d1d28f753cb19096b533d53418d.jpg\">\n    <img src=\"//yanxuan.nosdn.127.net/64b0f2f350969e9818a3b6c43c217325.jpg\">\n    <img src=\"//yanxuan.nosdn.127.net/a668e6ae7f1fa45565c1eac221787570.jpg\">\n    <img src=\"//yanxuan.nosdn.127.net/0d4004e19728f2707f08f4be79bbc774.jpg\">\n    <img src=\"//yanxuan.nosdn.127.net/79ee021bbe97de7ecda691de6787241f.jpg\">","avatar":"https://yanxuan.nosdn.127.net/14943186689221563.png","item_pic_url":"https://yanxuan.nosdn.127.net/14943267735961674.jpg","subtitle":"专业运动品牌同厂，毛毛虫鞋买二送一","topic_category_id":2,"price_info":0,"read_count":"6.4k","scene_pic_url":"https://yanxuan.nosdn.127.net/14943267735961674.jpg","topic_template_id":0,"topic_tag_id":0,"sort_order":1,"is_show":1}
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
         * id : 314
         * title : 关爱他成长的每一个足迹
         * content : <img src="//yanxuan.nosdn.127.net/75c55a13fde5eb2bc2dd6813b4c565cc.jpg">
         <img src="//yanxuan.nosdn.127.net/e27e1de2b271a28a21c10213b9df7e95.jpg">
         <img src="//yanxuan.nosdn.127.net/9d413d1d28f753cb19096b533d53418d.jpg">
         <img src="//yanxuan.nosdn.127.net/64b0f2f350969e9818a3b6c43c217325.jpg">
         <img src="//yanxuan.nosdn.127.net/a668e6ae7f1fa45565c1eac221787570.jpg">
         <img src="//yanxuan.nosdn.127.net/0d4004e19728f2707f08f4be79bbc774.jpg">
         <img src="//yanxuan.nosdn.127.net/79ee021bbe97de7ecda691de6787241f.jpg">
         * avatar : https://yanxuan.nosdn.127.net/14943186689221563.png
         * item_pic_url : https://yanxuan.nosdn.127.net/14943267735961674.jpg
         * subtitle : 专业运动品牌同厂，毛毛虫鞋买二送一
         * topic_category_id : 2
         * price_info : 0
         * read_count : 6.4k
         * scene_pic_url : https://yanxuan.nosdn.127.net/14943267735961674.jpg
         * topic_template_id : 0
         * topic_tag_id : 0
         * sort_order : 1
         * is_show : 1
         */

        private int id;
        private String title;
        private String content;
        private String avatar;
        private String item_pic_url;
        private String subtitle;
        private int topic_category_id;
        private String price_info;
        private String read_count;
        private String scene_pic_url;
        private int topic_template_id;
        private int topic_tag_id;
        private int sort_order;
        private int is_show;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getItem_pic_url() {
            return item_pic_url;
        }

        public void setItem_pic_url(String item_pic_url) {
            this.item_pic_url = item_pic_url;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public int getTopic_category_id() {
            return topic_category_id;
        }

        public void setTopic_category_id(int topic_category_id) {
            this.topic_category_id = topic_category_id;
        }

        public String getPrice_info() {
            return price_info;
        }

        public void setPrice_info(String price_info) {
            this.price_info = price_info;
        }

        public String getRead_count() {
            return read_count;
        }

        public void setRead_count(String read_count) {
            this.read_count = read_count;
        }

        public String getScene_pic_url() {
            return scene_pic_url;
        }

        public void setScene_pic_url(String scene_pic_url) {
            this.scene_pic_url = scene_pic_url;
        }

        public int getTopic_template_id() {
            return topic_template_id;
        }

        public void setTopic_template_id(int topic_template_id) {
            this.topic_template_id = topic_template_id;
        }

        public int getTopic_tag_id() {
            return topic_tag_id;
        }

        public void setTopic_tag_id(int topic_tag_id) {
            this.topic_tag_id = topic_tag_id;
        }

        public int getSort_order() {
            return sort_order;
        }

        public void setSort_order(int sort_order) {
            this.sort_order = sort_order;
        }

        public int getIs_show() {
            return is_show;
        }

        public void setIs_show(int is_show) {
            this.is_show = is_show;
        }
    }
}
