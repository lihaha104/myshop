package com.example.myshop.model.home;

import java.util.List;

public class ChannelRcyBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"count":170,"totalPages":17,"pageSize":10,"currentPage":1,"data":[{"id":1181000,"name":"母亲节礼物-舒适安睡组合","list_pic_url":"http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png","retail_price":2598},{"id":1155000,"name":"清新趣粉全棉四件套 条纹绿格","list_pic_url":"http://yanxuan.nosdn.127.net/d7d6ef1f1865991077384761b4521dce.png","retail_price":399},{"id":1152161,"name":"竹语丝麻印花四件套","list_pic_url":"http://yanxuan.nosdn.127.net/977401e75113f7c8334c4fb5b4bf6215.png","retail_price":459},{"id":1151013,"name":"简约知性全棉四件套 胭脂粉","list_pic_url":"http://yanxuan.nosdn.127.net/73a8692048f58f15e823b636d7c3bb74.png","retail_price":359},{"id":1151012,"name":"简约知性全棉四件套 素雅灰","list_pic_url":"http://yanxuan.nosdn.127.net/cb65635dbcef42b68ba21433f4948f5a.png","retail_price":359},{"id":1147048,"name":"简约知性系列居家地毯 蓝灰格","list_pic_url":"http://yanxuan.nosdn.127.net/fd7920a2eadd10fa10c0c03959a2abe0.png","retail_price":559},{"id":1147047,"name":"简约知性系列居家地毯 蓝粉拼接","list_pic_url":"http://yanxuan.nosdn.127.net/bda805b0a2464b6ec33c18981565e50e.png","retail_price":559},{"id":1147046,"name":"清新趣粉系列居家地毯 条纹间粉","list_pic_url":"http://yanxuan.nosdn.127.net/655d718df8107f8e7fd1dc6140e29039.png","retail_price":599},{"id":1147045,"name":"清新趣粉系列居家地毯 灰黄条纹","list_pic_url":"http://yanxuan.nosdn.127.net/5cda4a0c4c4ff9728d03186bd053c9ca.png","retail_price":599},{"id":1143015,"name":"婴儿床蔺草席","list_pic_url":"http://yanxuan.nosdn.127.net/50e197854e0ada79c37b7215a1574450.png","retail_price":79}],"filterCategory":[{"id":0,"name":"全部","checked":false},{"id":1005000,"name":"居家","checked":true},{"id":1005001,"name":"餐厨","checked":false},{"id":1008000,"name":"配件","checked":false},{"id":1010000,"name":"服装","checked":false},{"id":1013001,"name":"洗护","checked":false},{"id":1011000,"name":"婴童","checked":false},{"id":1012000,"name":"杂货","checked":false},{"id":1005002,"name":"饮食","checked":false},{"id":1019000,"name":"志趣","checked":false}],"goodsList":[{"id":1181000,"name":"母亲节礼物-舒适安睡组合","list_pic_url":"http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png","retail_price":2598},{"id":1155000,"name":"清新趣粉全棉四件套 条纹绿格","list_pic_url":"http://yanxuan.nosdn.127.net/d7d6ef1f1865991077384761b4521dce.png","retail_price":399},{"id":1152161,"name":"竹语丝麻印花四件套","list_pic_url":"http://yanxuan.nosdn.127.net/977401e75113f7c8334c4fb5b4bf6215.png","retail_price":459},{"id":1151013,"name":"简约知性全棉四件套 胭脂粉","list_pic_url":"http://yanxuan.nosdn.127.net/73a8692048f58f15e823b636d7c3bb74.png","retail_price":359},{"id":1151012,"name":"简约知性全棉四件套 素雅灰","list_pic_url":"http://yanxuan.nosdn.127.net/cb65635dbcef42b68ba21433f4948f5a.png","retail_price":359},{"id":1147048,"name":"简约知性系列居家地毯 蓝灰格","list_pic_url":"http://yanxuan.nosdn.127.net/fd7920a2eadd10fa10c0c03959a2abe0.png","retail_price":559},{"id":1147047,"name":"简约知性系列居家地毯 蓝粉拼接","list_pic_url":"http://yanxuan.nosdn.127.net/bda805b0a2464b6ec33c18981565e50e.png","retail_price":559},{"id":1147046,"name":"清新趣粉系列居家地毯 条纹间粉","list_pic_url":"http://yanxuan.nosdn.127.net/655d718df8107f8e7fd1dc6140e29039.png","retail_price":599},{"id":1147045,"name":"清新趣粉系列居家地毯 灰黄条纹","list_pic_url":"http://yanxuan.nosdn.127.net/5cda4a0c4c4ff9728d03186bd053c9ca.png","retail_price":599},{"id":1143015,"name":"婴儿床蔺草席","list_pic_url":"http://yanxuan.nosdn.127.net/50e197854e0ada79c37b7215a1574450.png","retail_price":79}]}
     */

    private int errno;
    private String errmsg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * count : 170
         * totalPages : 17
         * pageSize : 10
         * currentPage : 1
         * data : [{"id":1181000,"name":"母亲节礼物-舒适安睡组合","list_pic_url":"http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png","retail_price":2598},{"id":1155000,"name":"清新趣粉全棉四件套 条纹绿格","list_pic_url":"http://yanxuan.nosdn.127.net/d7d6ef1f1865991077384761b4521dce.png","retail_price":399},{"id":1152161,"name":"竹语丝麻印花四件套","list_pic_url":"http://yanxuan.nosdn.127.net/977401e75113f7c8334c4fb5b4bf6215.png","retail_price":459},{"id":1151013,"name":"简约知性全棉四件套 胭脂粉","list_pic_url":"http://yanxuan.nosdn.127.net/73a8692048f58f15e823b636d7c3bb74.png","retail_price":359},{"id":1151012,"name":"简约知性全棉四件套 素雅灰","list_pic_url":"http://yanxuan.nosdn.127.net/cb65635dbcef42b68ba21433f4948f5a.png","retail_price":359},{"id":1147048,"name":"简约知性系列居家地毯 蓝灰格","list_pic_url":"http://yanxuan.nosdn.127.net/fd7920a2eadd10fa10c0c03959a2abe0.png","retail_price":559},{"id":1147047,"name":"简约知性系列居家地毯 蓝粉拼接","list_pic_url":"http://yanxuan.nosdn.127.net/bda805b0a2464b6ec33c18981565e50e.png","retail_price":559},{"id":1147046,"name":"清新趣粉系列居家地毯 条纹间粉","list_pic_url":"http://yanxuan.nosdn.127.net/655d718df8107f8e7fd1dc6140e29039.png","retail_price":599},{"id":1147045,"name":"清新趣粉系列居家地毯 灰黄条纹","list_pic_url":"http://yanxuan.nosdn.127.net/5cda4a0c4c4ff9728d03186bd053c9ca.png","retail_price":599},{"id":1143015,"name":"婴儿床蔺草席","list_pic_url":"http://yanxuan.nosdn.127.net/50e197854e0ada79c37b7215a1574450.png","retail_price":79}]
         * filterCategory : [{"id":0,"name":"全部","checked":false},{"id":1005000,"name":"居家","checked":true},{"id":1005001,"name":"餐厨","checked":false},{"id":1008000,"name":"配件","checked":false},{"id":1010000,"name":"服装","checked":false},{"id":1013001,"name":"洗护","checked":false},{"id":1011000,"name":"婴童","checked":false},{"id":1012000,"name":"杂货","checked":false},{"id":1005002,"name":"饮食","checked":false},{"id":1019000,"name":"志趣","checked":false}]
         * goodsList : [{"id":1181000,"name":"母亲节礼物-舒适安睡组合","list_pic_url":"http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png","retail_price":2598},{"id":1155000,"name":"清新趣粉全棉四件套 条纹绿格","list_pic_url":"http://yanxuan.nosdn.127.net/d7d6ef1f1865991077384761b4521dce.png","retail_price":399},{"id":1152161,"name":"竹语丝麻印花四件套","list_pic_url":"http://yanxuan.nosdn.127.net/977401e75113f7c8334c4fb5b4bf6215.png","retail_price":459},{"id":1151013,"name":"简约知性全棉四件套 胭脂粉","list_pic_url":"http://yanxuan.nosdn.127.net/73a8692048f58f15e823b636d7c3bb74.png","retail_price":359},{"id":1151012,"name":"简约知性全棉四件套 素雅灰","list_pic_url":"http://yanxuan.nosdn.127.net/cb65635dbcef42b68ba21433f4948f5a.png","retail_price":359},{"id":1147048,"name":"简约知性系列居家地毯 蓝灰格","list_pic_url":"http://yanxuan.nosdn.127.net/fd7920a2eadd10fa10c0c03959a2abe0.png","retail_price":559},{"id":1147047,"name":"简约知性系列居家地毯 蓝粉拼接","list_pic_url":"http://yanxuan.nosdn.127.net/bda805b0a2464b6ec33c18981565e50e.png","retail_price":559},{"id":1147046,"name":"清新趣粉系列居家地毯 条纹间粉","list_pic_url":"http://yanxuan.nosdn.127.net/655d718df8107f8e7fd1dc6140e29039.png","retail_price":599},{"id":1147045,"name":"清新趣粉系列居家地毯 灰黄条纹","list_pic_url":"http://yanxuan.nosdn.127.net/5cda4a0c4c4ff9728d03186bd053c9ca.png","retail_price":599},{"id":1143015,"name":"婴儿床蔺草席","list_pic_url":"http://yanxuan.nosdn.127.net/50e197854e0ada79c37b7215a1574450.png","retail_price":79}]
         */

        private int count;
        private int totalPages;
        private int pageSize;
        private int currentPage;
        private List<DataBean> data;
        private List<FilterCategoryBean> filterCategory;
        private List<GoodsListBean> goodsList;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public List<FilterCategoryBean> getFilterCategory() {
            return filterCategory;
        }

        public void setFilterCategory(List<FilterCategoryBean> filterCategory) {
            this.filterCategory = filterCategory;
        }

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class DataBean {
            /**
             * id : 1181000
             * name : 母亲节礼物-舒适安睡组合
             * list_pic_url : http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png
             * retail_price : 2598
             */

            private int id;
            private String name;
            private String list_pic_url;
            private String retail_price;

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

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public String getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(String retail_price) {
                this.retail_price = retail_price;
            }
        }

        public static class FilterCategoryBean {
            /**
             * id : 0
             * name : 全部
             * checked : false
             */

            private int id;
            private String name;
            private boolean checked;

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

            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }
        }

        public static class GoodsListBean {
            /**
             * id : 1181000
             * name : 母亲节礼物-舒适安睡组合
             * list_pic_url : http://yanxuan.nosdn.127.net/1f67b1970ee20fd572b7202da0ff705d.png
             * retail_price : 2598
             */

            private int id;
            private String name;
            private String list_pic_url;
            private String retail_price;

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

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public String getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(String retail_price) {
                this.retail_price = retail_price;
            }
        }
    }
}
