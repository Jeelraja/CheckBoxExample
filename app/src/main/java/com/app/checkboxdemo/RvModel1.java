package com.app.checkboxdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class RvModel1 implements Parcelable {

    private String name;
    private boolean isChecked;

    public RvModel1() {

    }

    protected RvModel1(Parcel in) {
        name = in.readString();
        isChecked = in.readByte() != 0;
    }

    public static final Creator<RvModel1> CREATOR = new Creator<RvModel1>() {
        @Override
        public RvModel1 createFromParcel(Parcel in) {
            return new RvModel1(in);
        }

        @Override
        public RvModel1[] newArray(int size) {
            return new RvModel1[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeByte((byte) (isChecked ? 1 : 0));
    }
}
