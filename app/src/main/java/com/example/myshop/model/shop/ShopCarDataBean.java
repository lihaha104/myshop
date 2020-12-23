package com.example.myshop.model.shop;


import java.util.List;

public class ShopCarDataBean {
    /**
     * errno : 0
     * errmsg :
     * data : {"cartList":[{"id":626,"user_id":0,"session_id":"1","goods_id":1009012,"goods_sn":"1009012","product_id":14,"goods_name":"可水洗舒柔丝羽绒枕","market_price":59,"retail_price":59,"number":5,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/a196b367f23ccfd8205b6da647c62b84.png"},{"id":629,"user_id":0,"session_id":"1","goods_id":1152101,"goods_sn":"1152101","product_id":238,"goods_name":"魔兽世界 部落 奥格瑞玛 拉杆箱 可登机","market_price":888,"retail_price":888,"number":7,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/c1c62211a17b71a634fa0c705d11fb42.png"},{"id":630,"user_id":0,"session_id":"1","goods_id":1116011,"goods_sn":"1116011","product_id":167,"goods_name":"蔓越莓曲奇 200克","market_price":36,"retail_price":36,"number":14,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png"},{"id":631,"user_id":0,"session_id":"1","goods_id":1125017,"goods_sn":"1125017","product_id":175,"goods_name":"天鹅船创意摆件","market_price":99,"retail_price":99,"number":8,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/ae63fed274187e3e572043c53fefd836.png"},{"id":632,"user_id":0,"session_id":"1","goods_id":1045000,"goods_sn":"1045000","product_id":58,"goods_name":"绿茶蛋黄酥 200克/4枚入","market_price":28,"retail_price":28,"number":4,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/b2adc3fd9b84a289a1be03e8ee400e61.png"},{"id":633,"user_id":0,"session_id":"1","goods_id":1110004,"goods_sn":"1110004","product_id":144,"goods_name":"全棉针织纯色四件套","market_price":299,"retail_price":299,"number":2,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/1ffd5831e63027715445f74a28f8c4ed.png"},{"id":634,"user_id":0,"session_id":"1","goods_id":1134030,"goods_sn":"1134030","product_id":198,"goods_name":"简约知性记忆棉坐垫","market_price":46,"retail_price":46,"number":9,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png"},{"id":639,"user_id":0,"session_id":"1","goods_id":1030002,"goods_sn":"1030002","product_id":41,"goods_name":"160*230羊毛圈绒枪刺地毯","market_price":899,"retail_price":899,"number":15,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/8b9328496990357033d4259fda250679.png"},{"id":640,"user_id":0,"session_id":"1","goods_id":1155000,"goods_sn":"1155000","product_id":241,"goods_name":"清新趣粉全棉四件套 条纹绿格","market_price":399,"retail_price":399,"number":47,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/d7d6ef1f1865991077384761b4521dce.png"},{"id":641,"user_id":0,"session_id":"1","goods_id":1115023,"goods_sn":"1115023","product_id":160,"goods_name":"新年礼盒 双宫茧纱布美肤手工蚕丝被","market_price":1599,"retail_price":1599,"number":11,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/f3d1f0217ed250a37ea807f456351a51.png"},{"id":648,"user_id":0,"session_id":"1","goods_id":1015007,"goods_sn":"1015007","product_id":21,"goods_name":"典雅美式全棉刺绣抱枕","market_price":59,"retail_price":59,"number":2,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/a2045004de8a6225289376ad54317fc8.png"},{"id":650,"user_id":0,"session_id":"1","goods_id":1020000,"goods_sn":"1020000","product_id":26,"goods_name":"升级款记忆绵护椎腰靠","market_price":79,"retail_price":79,"number":49,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/819fdf1f635a694166bcfdd426416e8c.png"}],"cartTotal":{"goodsCount":173,"goodsAmount":62747,"checkedGoodsCount":160,"checkedGoodsAmount":45040}}
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
         * cartList : [{"id":626,"user_id":0,"session_id":"1","goods_id":1009012,"goods_sn":"1009012","product_id":14,"goods_name":"可水洗舒柔丝羽绒枕","market_price":59,"retail_price":59,"number":5,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/a196b367f23ccfd8205b6da647c62b84.png"},{"id":629,"user_id":0,"session_id":"1","goods_id":1152101,"goods_sn":"1152101","product_id":238,"goods_name":"魔兽世界 部落 奥格瑞玛 拉杆箱 可登机","market_price":888,"retail_price":888,"number":7,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/c1c62211a17b71a634fa0c705d11fb42.png"},{"id":630,"user_id":0,"session_id":"1","goods_id":1116011,"goods_sn":"1116011","product_id":167,"goods_name":"蔓越莓曲奇 200克","market_price":36,"retail_price":36,"number":14,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png"},{"id":631,"user_id":0,"session_id":"1","goods_id":1125017,"goods_sn":"1125017","product_id":175,"goods_name":"天鹅船创意摆件","market_price":99,"retail_price":99,"number":8,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/ae63fed274187e3e572043c53fefd836.png"},{"id":632,"user_id":0,"session_id":"1","goods_id":1045000,"goods_sn":"1045000","product_id":58,"goods_name":"绿茶蛋黄酥 200克/4枚入","market_price":28,"retail_price":28,"number":4,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/b2adc3fd9b84a289a1be03e8ee400e61.png"},{"id":633,"user_id":0,"session_id":"1","goods_id":1110004,"goods_sn":"1110004","product_id":144,"goods_name":"全棉针织纯色四件套","market_price":299,"retail_price":299,"number":2,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/1ffd5831e63027715445f74a28f8c4ed.png"},{"id":634,"user_id":0,"session_id":"1","goods_id":1134030,"goods_sn":"1134030","product_id":198,"goods_name":"简约知性记忆棉坐垫","market_price":46,"retail_price":46,"number":9,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png"},{"id":639,"user_id":0,"session_id":"1","goods_id":1030002,"goods_sn":"1030002","product_id":41,"goods_name":"160*230羊毛圈绒枪刺地毯","market_price":899,"retail_price":899,"number":15,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/8b9328496990357033d4259fda250679.png"},{"id":640,"user_id":0,"session_id":"1","goods_id":1155000,"goods_sn":"1155000","product_id":241,"goods_name":"清新趣粉全棉四件套 条纹绿格","market_price":399,"retail_price":399,"number":47,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/d7d6ef1f1865991077384761b4521dce.png"},{"id":641,"user_id":0,"session_id":"1","goods_id":1115023,"goods_sn":"1115023","product_id":160,"goods_name":"新年礼盒 双宫茧纱布美肤手工蚕丝被","market_price":1599,"retail_price":1599,"number":11,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/f3d1f0217ed250a37ea807f456351a51.png"},{"id":648,"user_id":0,"session_id":"1","goods_id":1015007,"goods_sn":"1015007","product_id":21,"goods_name":"典雅美式全棉刺绣抱枕","market_price":59,"retail_price":59,"number":2,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":0,"list_pic_url":"http://yanxuan.nosdn.127.net/a2045004de8a6225289376ad54317fc8.png"},{"id":650,"user_id":0,"session_id":"1","goods_id":1020000,"goods_sn":"1020000","product_id":26,"goods_name":"升级款记忆绵护椎腰靠","market_price":79,"retail_price":79,"number":49,"goods_specifition_name_value":"","goods_specifition_ids":"","checked":1,"list_pic_url":"http://yanxuan.nosdn.127.net/819fdf1f635a694166bcfdd426416e8c.png"}]
         * cartTotal : {"goodsCount":173,"goodsAmount":62747,"checkedGoodsCount":160,"checkedGoodsAmount":45040}
         */

        private CartTotalBean cartTotal;
        private List<CartListBean> cartList;

        public CartTotalBean getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(CartTotalBean cartTotal) {
            this.cartTotal = cartTotal;
        }

        public List<CartListBean> getCartList() {
            return cartList;
        }

        public void setCartList(List<CartListBean> cartList) {
            this.cartList = cartList;
        }

        public static class CartTotalBean {
            /**
             * goodsCount : 173
             * goodsAmount : 62747
             * checkedGoodsCount : 160
             * checkedGoodsAmount : 45040
             */

            private int goodsCount;
            private int goodsAmount;
            private int checkedGoodsCount;
            private int checkedGoodsAmount;

            public int getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(int goodsCount) {
                this.goodsCount = goodsCount;
            }

            public int getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(int goodsAmount) {
                this.goodsAmount = goodsAmount;
            }

            public int getCheckedGoodsCount() {
                return checkedGoodsCount;
            }

            public void setCheckedGoodsCount(int checkedGoodsCount) {
                this.checkedGoodsCount = checkedGoodsCount;
            }

            public int getCheckedGoodsAmount() {
                return checkedGoodsAmount;
            }

            public void setCheckedGoodsAmount(int checkedGoodsAmount) {
                this.checkedGoodsAmount = checkedGoodsAmount;
            }
        }

        public static class CartListBean {
            /**
             * id : 626
             * user_id : 0
             * session_id : 1
             * goods_id : 1009012
             * goods_sn : 1009012
             * product_id : 14
             * goods_name : 可水洗舒柔丝羽绒枕
             * market_price : 59
             * retail_price : 59
             * number : 5
             * goods_specifition_name_value :
             * goods_specifition_ids :
             * checked : 1
             * list_pic_url : http://yanxuan.nosdn.127.net/a196b367f23ccfd8205b6da647c62b84.png
             */

            private int id;
            private int user_id;
            private String session_id;
            private int goods_id;
            private String goods_sn;
            private int product_id;
            private String goods_name;
            private int market_price;
            private int retail_price;
            private int number;
            private String goods_specifition_name_value;
            private String goods_specifition_ids;
            private int checked;
            private String list_pic_url;
            public boolean selectOrder;  //下单状态
            public boolean selectEdit;  //编辑状态

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getSession_id() {
                return session_id;
            }

            public void setSession_id(String session_id) {
                this.session_id = session_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public int getMarket_price() {
                return market_price;
            }

            public void setMarket_price(int market_price) {
                this.market_price = market_price;
            }

            public int getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(int retail_price) {
                this.retail_price = retail_price;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getGoods_specifition_name_value() {
                return goods_specifition_name_value;
            }

            public void setGoods_specifition_name_value(String goods_specifition_name_value) {
                this.goods_specifition_name_value = goods_specifition_name_value;
            }

            public String getGoods_specifition_ids() {
                return goods_specifition_ids;
            }

            public void setGoods_specifition_ids(String goods_specifition_ids) {
                this.goods_specifition_ids = goods_specifition_ids;
            }

            public int getChecked() {
                return checked;
            }

            public void setChecked(int checked) {
                this.checked = checked;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public boolean isSelectOrder() {
                return selectOrder;
            }

            public void setSelectOrder(boolean selectOrder) {
                this.selectOrder = selectOrder;
            }

            public boolean isSelectEdit() {
                return selectEdit;
            }

            public void setSelectEdit(boolean selectEdit) {
                this.selectEdit = selectEdit;
            }
        }
    }
}

