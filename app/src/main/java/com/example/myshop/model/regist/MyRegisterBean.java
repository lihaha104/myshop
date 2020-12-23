package com.example.myshop.model.regist;

public class MyRegisterBean {

    /**
     * data : {"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiMGFhZWFjOGEtZDM3MC00MDNkLTllZGEtNTFkOTFhZWMxMzBkIiwiaWF0IjoxNjA4NjI1NjEwfQ.TBg4WCtuSPyFjLAKWu64WZXqLATt3qzUCYW93koCHHw","userInfo":{"avatar":"","birthday":0,"gender":0,"uid":"0aaeac8a-d370-403d-9eda-51d91aec130d","username":"lxy122"}}
     * errmsg :
     * errno : 0
     */

    private DataBean data;
    private String errmsg;
    private int errno;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public static class DataBean {
        /**
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiMGFhZWFjOGEtZDM3MC00MDNkLTllZGEtNTFkOTFhZWMxMzBkIiwiaWF0IjoxNjA4NjI1NjEwfQ.TBg4WCtuSPyFjLAKWu64WZXqLATt3qzUCYW93koCHHw
         * userInfo : {"avatar":"","birthday":0,"gender":0,"uid":"0aaeac8a-d370-403d-9eda-51d91aec130d","username":"lxy122"}
         */

        private String token;
        private UserInfoBean userInfo;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * avatar :
             * birthday : 0
             * gender : 0
             * uid : 0aaeac8a-d370-403d-9eda-51d91aec130d
             * username : lxy122
             */

            private String avatar;
            private int birthday;
            private int gender;
            private String uid;
            private String username;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getBirthday() {
                return birthday;
            }

            public void setBirthday(int birthday) {
                this.birthday = birthday;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }
}
