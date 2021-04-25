package com.cmis.userinterface;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EntryDao {
    @Query("SELECT * FROM Entry")
    List<Entry> getAll();

    @Insert
    void insertEntry(Entry entry);
}
