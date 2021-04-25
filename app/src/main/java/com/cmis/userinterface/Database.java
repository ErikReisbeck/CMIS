package com.cmis.userinterface;


import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {User.class, Entry.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract EntryDao entriesDao();

    private static volatile Database INSTANCE = null;

    static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "app_db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
