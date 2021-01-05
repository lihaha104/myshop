package com.example.myshop.model.me;

public class UserInfoBean {


    /**
     * errno : 0
     * errmsg :
     * data : {"uid":"f4718973-0a02-4f6b-aa9a-19a22d9aa9ad","username":"wsq","nickname":null,"avatar":"","birthday":0,"mark":null}
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
         * uid : f4718973-0a02-4f6b-aa9a-19a22d9aa9ad
         * username : wsq
         * nickname : null
         * avatar :
         * birthday : 0
         * mark : null
         */

        private String uid;
        private String username;
        private Object nickname;
        private String avatar;
        private int birthday;
        private Object mark;

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

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

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

        public Object getMark() {
            return mark;
        }

        public void setMark(Object mark) {
            this.mark = mark;
        }
    }
}
