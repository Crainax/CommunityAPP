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
 * @since 2016/7/13 <br/>
 */
public class EvaluateInfo implements Parcelable{

    private boolean evaluate;
    private float rating;
    private UserInfo userInfo;

    public boolean isEvaluate() {
        return evaluate;
    }

    public void setEvaluate(boolean evaluate) {
        this.evaluate = evaluate;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.evaluate ? (byte) 1 : (byte) 0);
        dest.writeFloat(this.rating);
        dest.writeParcelable(this.userInfo, flags);
    }

    public EvaluateInfo() {
    }

    protected EvaluateInfo(Parcel in) {
        this.evaluate = in.readByte() != 0;
        this.rating = in.readFloat();
        this.userInfo = in.readParcelable(UserInfo.class.getClassLoader());
    }

    public static final Creator<EvaluateInfo> CREATOR = new Creator<EvaluateInfo>() {
        @Override
        public EvaluateInfo createFromParcel(Parcel source) {
            return new EvaluateInfo(source);
        }

        @Override
        public EvaluateInfo[] newArray(int size) {
            return new EvaluateInfo[size];
        }
    };
}
