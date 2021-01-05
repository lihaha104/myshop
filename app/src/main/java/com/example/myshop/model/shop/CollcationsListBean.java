package com.example.myshop.model.shop;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CollcationsListBean extends RealmObject {
    private int Id;//主键
    private String pic;//图片
    private String name;//名字	3
    private String content;//内容	zzz
    private String price;//价格	zzzz

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CollcationsListBean{" +
                "Id=" + Id +
                ", pic='" + pic + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
