package com.cmis.userinterface;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDate;

public class incomeEntry implements Parcelable {

    private int amount;
    private String category;
    private String date; //Change to localdate or somthg else

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public incomeEntry createFromParcel(Parcel in) {
            return new incomeEntry(in);
        }

        public incomeEntry[] newArray(int size) {
            return new incomeEntry[size];
        }

    };

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public incomeEntry(){

    }
    public incomeEntry(Parcel in){
        this.amount = in.readInt();
        this.category = in.readString();
        this.date = in.readString();
    }

    public incomeEntry(int amount, String category, String date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.amount);
        dest.writeString(this.category);
        dest.writeString(this.date);
    }
    public String toString(){
        return "incomeEntry" + "Amount= " + amount + ", Category=" + category + ", Date=" + date;
    }
}
