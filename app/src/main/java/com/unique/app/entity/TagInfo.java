package com.unique.app.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.entity <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/10 <br/>
 */
public class TagInfo implements Parcelable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public TagInfo() {
    }

    protected TagInfo(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<TagInfo> CREATOR = new Creator<TagInfo>() {
        @Override
        public TagInfo createFromParcel(Parcel source) {
            return new TagInfo(source);
        }

        @Override
        public TagInfo[] newArray(int size) {
            return new TagInfo[size];
        }
    };
}
