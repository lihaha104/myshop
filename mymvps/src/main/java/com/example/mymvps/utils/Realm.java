package com.example.mymvps.utils;

import android.content.Context;

import java.security.SecureRandom;

import io.realm.RealmConfiguration;

/*数据库*/
public class Realm {
    public static io.realm.Realm getRealm(Context context){
        byte[] bytes = new byte[1024];
        new SecureRandom().nextBytes(bytes);
        io.realm.Realm.init(context);

//        Migration migration = new Migration();
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("db.realm")
                .schemaVersion(2)
                //.migration(migration)
                .deleteRealmIfMigrationNeeded()
                .build();
        return io.realm.Realm.getInstance(config);
    }
  /*  public static RealmConfiguration getRealm(){
       *//* byte[] bytes = new byte[1024];

        new SecureRandom().nextBytes(SpUtils.getInstance().getString("token").getBytes());
        io.realm.Realm.init(MyApp.app);*//*

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("test.realm")
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                //.migration(new CustomMigration())//升级数据库
                .build();

        return configuration;
    }

    private static class CustomMigration implements RealmMigration {
        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        }
    }
*/}