package com.cmis.userinterface;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Entry {
    @PrimaryKey(autoGenerate = true)
    public int entryId;

    public int amount;

    public String date;

    public String category;

    public Entry(int amount, String category, String date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

}
