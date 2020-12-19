package com.example.myshop.interfaces;

public interface Callback<T> {

    void success(T t);

    void fail(String err);

}
