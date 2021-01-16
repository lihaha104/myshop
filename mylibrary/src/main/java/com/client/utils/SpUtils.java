package com.client.utils;

import android.content.Context;
import android.content.SharedPreferences;


import com.client.app.MyApplication;


public class SpUtils {
    private static SpUtils instance;
    private SharedPreferences sp;
    public SpUtils(){
        sp = MyApplication.myapp.getSharedPreferences("chat", Context.MODE_PRIVATE);
    }

    public static SpUtils getInstance(){
        if(instance == null){
            synchronized (SpUtils.class){
                if(instance == null){
                    instance = new SpUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 设置数据
     * @param key
     * @param value
     */
    public void setValue(String key, Object value){
        SharedPreferences.Editor editor = sp.edit();
        if(value instanceof String){
            editor.putString(key, (String) value);
        }else if(value instanceof Integer){
            editor.putInt(key, (Integer) value);
        }else if(value instanceof Boolean){
            editor.putBoolean(key, (Boolean) value);
        }else if(value instanceof Float){
            editor.putFloat(key, (Float) value);
        }else if(value instanceof Long){
            editor.putLong(key, (Long) value);
        }
        editor.commit();
    }

    public String getString(String key){
        return sp.getString(key,"");
    }

    public int getInt(String key){
        return sp.getInt(key,0);
    }

    public Boolean getBoolean(String key){
        return sp.getBoolean(key,false);
    }

    public float getFloat(String key){
        return sp.getFloat(key,0);
    }

    public Long getLong(String key){
        return sp.getLong(key,0);
    }


    /**
     * 删除对应的key
     * @param key
     */
    public void remove(String key){
        sp.edit().remove(key).commit();
    }
    /**
     * 删除所有
     * */
    public void delete(){
        sp.edit().clear().commit();
    }

}
