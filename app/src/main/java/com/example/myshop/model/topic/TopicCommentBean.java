package com.example.myshop.model.topic;

import java.util.List;

public class TopicCommentBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"count":12,"totalPages":3,"pageSize":5,"currentPage":1,"data":[{"content":"是记忆棉 很满意","type_id":1,"value_id":314,"id":994,"add_time":"2017-05-15 10:06:01","user_info":{"username":"z123","avatar":"","nickname":null},"pic_list":[]},{"content":"很好的东西","type_id":1,"value_id":314,"id":995,"add_time":"2017-05-15 23:56:28","user_info":{"username":"z123","avatar":"","nickname":null},"pic_list":[]},{"content":"很舒服，有没有那么的软，不错！","type_id":1,"value_id":314,"id":996,"add_time":"2017-04-16 11:12:46","user_info":{"username":"z123","avatar":"","nickname":null},"pic_list":[]},{"content":"确实舒服，不过夏天会不会热啊？","type_id":1,"value_id":314,"id":997,"add_time":"2017-05-14 07:23:56","user_info":{"username":"z123","avatar":"","nickname":null},"pic_list":[]},{"content":"有点过软。等到夏季，上面直接铺凉席的话，不知道透气性会怎样？","type_id":1,"value_id":314,"id":998,"add_time":"2016-12-01 17:58:54","user_info":{"username":"z123","avatar":"","nickname":null},"pic_list":[]}]}
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
         * count : 12
         * totalPages : 3
         * pageSize : 5
         * currentPage : 1
         * data : [{"content":"是记忆棉 很满意","type_id":1,"value_id":314,"id":994,"add_time":"2017-05-15 10:06:01","user_info":{"username":"z123","avatar":"","nickname":null},"pic_list":[]},{"content":"很好的东西","type_id":1,"value_id":314,"id":995,"add_time":"2017-05-15 23:56:28","user_info":{"username":"z123","avatar":"","nickname":null},"pic_list":[]},{"content":"很舒服，有没有那么的软，不错！","type_id":1,"value_id":314,"id":996,"add_time":"2017-04-16 11:12:46","user_info":{"username":"z123","avatar":"","nickname":null},"pic_list":[]},{"content":"确实舒服，不过夏天会不会热啊？","type_id":1,"value_id":314,"id":997,"add_time":"2017-05-14 07:23:56","user_info":{"username":"z123","avatar":"","nickname":null},"pic_list":[]},{"content":"有点过软。等到夏季，上面直接铺凉席的话，不知道透气性会怎样？","type_id":1,"value_id":314,"id":998,"add_time":"2016-12-01 17:58:54","user_info":{"username":"z123","avatar":"","nickname":null},"pic_list":[]}]
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
             * content : 是记忆棉 很满意
             * type_id : 1
             * value_id : 314
             * id : 994
             * add_time : 2017-05-15 10:06:01
             * user_info : {"username":"z123","avatar":"","nickname":null}
             * pic_list : []
             */

            private String content;
            private int type_id;
            private int value_id;
            private int id;
            private String add_time;
            private UserInfoBean user_info;
            private List<?> pic_list;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getType_id() {
                return type_id;
            }

            public void setType_id(int type_id) {
                this.type_id = type_id;
            }

            public int getValue_id() {
                return value_id;
            }

            public void setValue_id(int value_id) {
                this.value_id = value_id;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public UserInfoBean getUser_info() {
                return user_info;
            }

            public void setUser_info(UserInfoBean user_info) {
                this.user_info = user_info;
            }

            public List<?> getPic_list() {
                return pic_list;
            }

            public void setPic_list(List<?> pic_list) {
                this.pic_list = pic_list;
            }

            public static class UserInfoBean {
                /**
                 * username : z123
                 * avatar :
                 * nickname : null
                 */

                private String username;
                private String avatar;
                private Object nickname;

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public Object getNickname() {
                    return nickname;
                }

                public void setNickname(Object nickname) {
                    this.nickname = nickname;
                }
            }
        }
    }
}
