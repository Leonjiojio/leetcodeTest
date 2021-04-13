package com.sinovoice.leetcodetest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by  on 2021/4/9.
 **/
class PBean implements Parcelable {

    protected PBean(Parcel in) {

    }

    public static final Creator<PBean> CREATOR = new Creator<PBean>() {
        @Override
        public PBean createFromParcel(Parcel in) {
            return new PBean(in);
        }

        @Override
        public PBean[] newArray(int size) {
            return new PBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
