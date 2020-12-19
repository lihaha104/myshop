package com.example.myshop.model.home;

import java.util.List;

public class BrandTitleBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"count":49,"totalPages":1,"pageSize":1000,"currentPage":1,"data":[{"id":1001000,"name":"MUJI制造商","floor_price":12.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png"},{"id":1001002,"name":"内野制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/8ca3ce091504f8aa1fba3fdbb7a6e351.png"},{"id":1001003,"name":"Adidas制造商","floor_price":49,"app_list_pic_url":"http://yanxuan.nosdn.127.net/335334d0deaff6dc3376334822ab3a2f.png"},{"id":1001007,"name":"优衣库制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/0d72832e37e7e3ea391b519abbbc95a3.png"},{"id":1001008,"name":"膳魔师制造商","floor_price":45,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5fd51e29b9459dae7df8040c8219f241.png"},{"id":1001010,"name":"星巴克制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5668bc50f2f2e551891044525710dc84.png"},{"id":1001012,"name":"Wedgwood制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/68940e8e23f96dbeb3548d943d83d5e4.png"},{"id":1001013,"name":"Royal Doulton制造商","floor_price":24.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/0de643a02043fd9680b11e21c452adaa.png"},{"id":1001015,"name":"日本KEYUCA制造商","floor_price":14.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/9b85b45f23da558be101dbcc273b1d6d.png"},{"id":1001016,"name":"爱慕制造商","floor_price":35,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5104f84110eac111968c63c18ebd62c0.png"},{"id":1001020,"name":"Ralph Lauren制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/9df78eb751eae2546bd3ee7e61c9b854.png"},{"id":1001037,"name":"新秀丽制造商","floor_price":59,"app_list_pic_url":"http://yanxuan.nosdn.127.net/80dce660938931956ee9a3a2b111bd37.jpg"},{"id":1001038,"name":"Coach制造商","floor_price":49,"app_list_pic_url":"http://yanxuan.nosdn.127.net/1b1cc16135fd8467d40983f75f644127.png"},{"id":1001039,"name":"MK制造商","floor_price":79,"app_list_pic_url":"http://yanxuan.nosdn.127.net/fc9cd1309374f7707855de80522fb310.jpg"},{"id":1001045,"name":"罗莱制造商","floor_price":699,"app_list_pic_url":"http://yanxuan.nosdn.127.net/14122a41a4985d23e1a172302ee818e9.png"},{"id":1003000,"name":"Carters制造商","floor_price":19.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/efe9131599ced0297213e6ec67eb2174.png"},{"id":1005001,"name":"Goody制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/7c918f37de108f3687d69b39daab34eb.png"},{"id":1006000,"name":"范思哲制造商","floor_price":99,"app_list_pic_url":"http://yanxuan.nosdn.127.net/c80ae035387495a61a4515906205efff.png"},{"id":1008000,"name":"WPC制造商","floor_price":59,"app_list_pic_url":"http://yanxuan.nosdn.127.net/c4e97cc87186ce17f9316f3ba39e220c.png"},{"id":1010001,"name":"竹宝堂制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/61b0b7ae4f0163422009defbceaa41ad.jpg"},{"id":1010002,"name":"资生堂制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5449236b80d1e678dedee2f626cd67c4.png"},{"id":1015000,"name":"NITORI制造商","floor_price":69,"app_list_pic_url":"http://yanxuan.nosdn.127.net/6f3d310601b18610553c675e0e14d107.png"},{"id":1016002,"name":"HUGO BOSS制造商","floor_price":45,"app_list_pic_url":"http://yanxuan.nosdn.127.net/70ada9877b2efa82227437af3231fe50.png"},{"id":1018000,"name":"Sperry制造商","floor_price":199,"app_list_pic_url":"http://yanxuan.nosdn.127.net/2eb12d84037346441088267432da31c4.png"},{"id":1021000,"name":"Marc Jacobs制造商","floor_price":69,"app_list_pic_url":"http://yanxuan.nosdn.127.net/c8dac4eb1a458d778420ba520edab3d0.png"},{"id":1022000,"name":"UGG制造商","floor_price":59,"app_list_pic_url":"http://yanxuan.nosdn.127.net/4d2a3dea7e0172ae48e8161f04cfa045.jpg"},{"id":1022001,"name":"Palladium制造商","floor_price":249,"app_list_pic_url":"http://yanxuan.nosdn.127.net/3480f2a4026c60eb4921f0aa3facbde8.png"},{"id":1023000,"name":"PetitBateau小帆船制造商","floor_price":36,"app_list_pic_url":"http://yanxuan.nosdn.127.net/1a11438598f1bb52b1741e123b523cb5.jpg"},{"id":1024000,"name":"WMF制造商","floor_price":9.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/2018e9ac91ec37d9aaf437a1fd5d7070.png"},{"id":1024001,"name":"OBH制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/bf3499ac17a11ffb9bb7caa47ebef2dd.png"},{"id":1024003,"name":"Stoneline制造商","floor_price":9.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/3a44ae7db86f3f9b6e542720c54cc349.png"},{"id":1024006,"name":"KitchenAid制造商","floor_price":98,"app_list_pic_url":"http://yanxuan.nosdn.127.net/e11385bf29d1b3949435b80fcd000948.png"},{"id":1025000,"name":"Timberland制造商","floor_price":359,"app_list_pic_url":"http://yanxuan.nosdn.127.net/6dcadb0791b33aa9fd00380b44fa6645.png"},{"id":1025001,"name":"Kenneth Cole制造商","floor_price":349,"app_list_pic_url":"http://yanxuan.nosdn.127.net/236322546c6860e1662ab147d6b0ba2f.jpg"},{"id":1026000,"name":"CK制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/658f09b7ec522d31742b47b914d64338.png"},{"id":1026001,"name":"Under Armour制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/4e93ea29b1d06fabfd24ba68a9b20a34.jpg"},{"id":1028000,"name":"Gucci制造商","floor_price":59,"app_list_pic_url":"http://yanxuan.nosdn.127.net/278869cad9bf5411ffc18982686b88fb.jpg"},{"id":1028003,"name":"Burberry制造商","floor_price":99,"app_list_pic_url":"http://yanxuan.nosdn.127.net/07af01e281c7e0b912d162d611e22c32.jpg"},{"id":1033003,"name":"Armani制造商","floor_price":199,"app_list_pic_url":"http://yanxuan.nosdn.127.net/981e06f0f46f5f1f041d7de3dd3202e6.jpg"},{"id":1033004,"name":"爱马仕集团制造商","floor_price":19,"app_list_pic_url":"http://yanxuan.nosdn.127.net/d98470dd728fb5a91f7aceade07572b5.png"},{"id":1034001,"name":"Alexander McQueen制造商","floor_price":69,"app_list_pic_url":"http://yanxuan.nosdn.127.net/db7ee9667d84cbce573688297586699c.jpg"},{"id":1037000,"name":"厚木ATSUGI制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/7df55c408dbac6085ed6c30836c828ac.jpg"},{"id":1038000,"name":"Birkenstock集团制造商","floor_price":59.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/05a2ecffb60b77e4c165bd8492e5c22a.jpg"},{"id":1038001,"name":"Nine West制造商","floor_price":219,"app_list_pic_url":"http://yanxuan.nosdn.127.net/ad4df7848ce450f00483c2d5e9f2bfa7.png"},{"id":1039000,"name":"TEFAL制造商","floor_price":259,"app_list_pic_url":"http://yanxuan.nosdn.127.net/2b7a07e25a3f3be886a7fb90ba975bb7.png"},{"id":1039001,"name":"京瓷制造商","floor_price":89,"app_list_pic_url":"http://yanxuan.nosdn.127.net/3dda530605e3ab1c82d5ed30f2489473.png"},{"id":1040000,"name":"Tescom制造商","floor_price":59,"app_list_pic_url":"http://yanxuan.nosdn.127.net/c17cd65971189fdc28f5bd6b78f657a7.png"},{"id":1041000,"name":"BCBG制造商","floor_price":99,"app_list_pic_url":"http://yanxuan.nosdn.127.net/b9072023afd3621714fd5c49f140fca8.png"},{"id":1046000,"name":"Police制造商","floor_price":109,"app_list_pic_url":"http://yanxuan.nosdn.127.net/66e2cb956a9dd1efc7732bea278e901e.png"}]}
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
         * count : 49
         * totalPages : 1
         * pageSize : 1000
         * currentPage : 1
         * data : [{"id":1001000,"name":"MUJI制造商","floor_price":12.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png"},{"id":1001002,"name":"内野制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/8ca3ce091504f8aa1fba3fdbb7a6e351.png"},{"id":1001003,"name":"Adidas制造商","floor_price":49,"app_list_pic_url":"http://yanxuan.nosdn.127.net/335334d0deaff6dc3376334822ab3a2f.png"},{"id":1001007,"name":"优衣库制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/0d72832e37e7e3ea391b519abbbc95a3.png"},{"id":1001008,"name":"膳魔师制造商","floor_price":45,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5fd51e29b9459dae7df8040c8219f241.png"},{"id":1001010,"name":"星巴克制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5668bc50f2f2e551891044525710dc84.png"},{"id":1001012,"name":"Wedgwood制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/68940e8e23f96dbeb3548d943d83d5e4.png"},{"id":1001013,"name":"Royal Doulton制造商","floor_price":24.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/0de643a02043fd9680b11e21c452adaa.png"},{"id":1001015,"name":"日本KEYUCA制造商","floor_price":14.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/9b85b45f23da558be101dbcc273b1d6d.png"},{"id":1001016,"name":"爱慕制造商","floor_price":35,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5104f84110eac111968c63c18ebd62c0.png"},{"id":1001020,"name":"Ralph Lauren制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/9df78eb751eae2546bd3ee7e61c9b854.png"},{"id":1001037,"name":"新秀丽制造商","floor_price":59,"app_list_pic_url":"http://yanxuan.nosdn.127.net/80dce660938931956ee9a3a2b111bd37.jpg"},{"id":1001038,"name":"Coach制造商","floor_price":49,"app_list_pic_url":"http://yanxuan.nosdn.127.net/1b1cc16135fd8467d40983f75f644127.png"},{"id":1001039,"name":"MK制造商","floor_price":79,"app_list_pic_url":"http://yanxuan.nosdn.127.net/fc9cd1309374f7707855de80522fb310.jpg"},{"id":1001045,"name":"罗莱制造商","floor_price":699,"app_list_pic_url":"http://yanxuan.nosdn.127.net/14122a41a4985d23e1a172302ee818e9.png"},{"id":1003000,"name":"Carters制造商","floor_price":19.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/efe9131599ced0297213e6ec67eb2174.png"},{"id":1005001,"name":"Goody制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/7c918f37de108f3687d69b39daab34eb.png"},{"id":1006000,"name":"范思哲制造商","floor_price":99,"app_list_pic_url":"http://yanxuan.nosdn.127.net/c80ae035387495a61a4515906205efff.png"},{"id":1008000,"name":"WPC制造商","floor_price":59,"app_list_pic_url":"http://yanxuan.nosdn.127.net/c4e97cc87186ce17f9316f3ba39e220c.png"},{"id":1010001,"name":"竹宝堂制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/61b0b7ae4f0163422009defbceaa41ad.jpg"},{"id":1010002,"name":"资生堂制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/5449236b80d1e678dedee2f626cd67c4.png"},{"id":1015000,"name":"NITORI制造商","floor_price":69,"app_list_pic_url":"http://yanxuan.nosdn.127.net/6f3d310601b18610553c675e0e14d107.png"},{"id":1016002,"name":"HUGO BOSS制造商","floor_price":45,"app_list_pic_url":"http://yanxuan.nosdn.127.net/70ada9877b2efa82227437af3231fe50.png"},{"id":1018000,"name":"Sperry制造商","floor_price":199,"app_list_pic_url":"http://yanxuan.nosdn.127.net/2eb12d84037346441088267432da31c4.png"},{"id":1021000,"name":"Marc Jacobs制造商","floor_price":69,"app_list_pic_url":"http://yanxuan.nosdn.127.net/c8dac4eb1a458d778420ba520edab3d0.png"},{"id":1022000,"name":"UGG制造商","floor_price":59,"app_list_pic_url":"http://yanxuan.nosdn.127.net/4d2a3dea7e0172ae48e8161f04cfa045.jpg"},{"id":1022001,"name":"Palladium制造商","floor_price":249,"app_list_pic_url":"http://yanxuan.nosdn.127.net/3480f2a4026c60eb4921f0aa3facbde8.png"},{"id":1023000,"name":"PetitBateau小帆船制造商","floor_price":36,"app_list_pic_url":"http://yanxuan.nosdn.127.net/1a11438598f1bb52b1741e123b523cb5.jpg"},{"id":1024000,"name":"WMF制造商","floor_price":9.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/2018e9ac91ec37d9aaf437a1fd5d7070.png"},{"id":1024001,"name":"OBH制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/bf3499ac17a11ffb9bb7caa47ebef2dd.png"},{"id":1024003,"name":"Stoneline制造商","floor_price":9.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/3a44ae7db86f3f9b6e542720c54cc349.png"},{"id":1024006,"name":"KitchenAid制造商","floor_price":98,"app_list_pic_url":"http://yanxuan.nosdn.127.net/e11385bf29d1b3949435b80fcd000948.png"},{"id":1025000,"name":"Timberland制造商","floor_price":359,"app_list_pic_url":"http://yanxuan.nosdn.127.net/6dcadb0791b33aa9fd00380b44fa6645.png"},{"id":1025001,"name":"Kenneth Cole制造商","floor_price":349,"app_list_pic_url":"http://yanxuan.nosdn.127.net/236322546c6860e1662ab147d6b0ba2f.jpg"},{"id":1026000,"name":"CK制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/658f09b7ec522d31742b47b914d64338.png"},{"id":1026001,"name":"Under Armour制造商","floor_price":39,"app_list_pic_url":"http://yanxuan.nosdn.127.net/4e93ea29b1d06fabfd24ba68a9b20a34.jpg"},{"id":1028000,"name":"Gucci制造商","floor_price":59,"app_list_pic_url":"http://yanxuan.nosdn.127.net/278869cad9bf5411ffc18982686b88fb.jpg"},{"id":1028003,"name":"Burberry制造商","floor_price":99,"app_list_pic_url":"http://yanxuan.nosdn.127.net/07af01e281c7e0b912d162d611e22c32.jpg"},{"id":1033003,"name":"Armani制造商","floor_price":199,"app_list_pic_url":"http://yanxuan.nosdn.127.net/981e06f0f46f5f1f041d7de3dd3202e6.jpg"},{"id":1033004,"name":"爱马仕集团制造商","floor_price":19,"app_list_pic_url":"http://yanxuan.nosdn.127.net/d98470dd728fb5a91f7aceade07572b5.png"},{"id":1034001,"name":"Alexander McQueen制造商","floor_price":69,"app_list_pic_url":"http://yanxuan.nosdn.127.net/db7ee9667d84cbce573688297586699c.jpg"},{"id":1037000,"name":"厚木ATSUGI制造商","floor_price":29,"app_list_pic_url":"http://yanxuan.nosdn.127.net/7df55c408dbac6085ed6c30836c828ac.jpg"},{"id":1038000,"name":"Birkenstock集团制造商","floor_price":59.9,"app_list_pic_url":"http://yanxuan.nosdn.127.net/05a2ecffb60b77e4c165bd8492e5c22a.jpg"},{"id":1038001,"name":"Nine West制造商","floor_price":219,"app_list_pic_url":"http://yanxuan.nosdn.127.net/ad4df7848ce450f00483c2d5e9f2bfa7.png"},{"id":1039000,"name":"TEFAL制造商","floor_price":259,"app_list_pic_url":"http://yanxuan.nosdn.127.net/2b7a07e25a3f3be886a7fb90ba975bb7.png"},{"id":1039001,"name":"京瓷制造商","floor_price":89,"app_list_pic_url":"http://yanxuan.nosdn.127.net/3dda530605e3ab1c82d5ed30f2489473.png"},{"id":1040000,"name":"Tescom制造商","floor_price":59,"app_list_pic_url":"http://yanxuan.nosdn.127.net/c17cd65971189fdc28f5bd6b78f657a7.png"},{"id":1041000,"name":"BCBG制造商","floor_price":99,"app_list_pic_url":"http://yanxuan.nosdn.127.net/b9072023afd3621714fd5c49f140fca8.png"},{"id":1046000,"name":"Police制造商","floor_price":109,"app_list_pic_url":"http://yanxuan.nosdn.127.net/66e2cb956a9dd1efc7732bea278e901e.png"}]
         */

        private int count;
        private int totalPages;
        private int pageSize;
        private int currentPage;
        private List<DataBean> data;

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

        public static class DataBean {
            /**
             * id : 1001000
             * name : MUJI制造商
             * floor_price : 12.9
             * app_list_pic_url : http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png
             */

            private int id;
            private String name;
            private String floor_price;
            private String app_list_pic_url;

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

            public String getFloor_price() {
                return floor_price;
            }

            public void setFloor_price(String floor_price) {
                this.floor_price = floor_price;
            }

            public String getApp_list_pic_url() {
                return app_list_pic_url;
            }

            public void setApp_list_pic_url(String app_list_pic_url) {
                this.app_list_pic_url = app_list_pic_url;
            }
        }
    }
}
