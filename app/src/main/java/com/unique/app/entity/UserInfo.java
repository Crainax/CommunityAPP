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

public class UserInfo implements Parcelable {

    private String userName;
    private String avatarUrl;
    private int launchActCount;
    private int partakeInNum;
    private float friendlyNum;
    private String tel;
    private boolean isPrivate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getLaunchActCount() {
        return launchActCount;
    }

    public void setLaunchActCount(int launchActCount) {
        this.launchActCount = launchActCount;
    }

    public int getPartakeInNum() {
        return partakeInNum;
    }

    public void setPartakeInNum(int partakeInNum) {
        this.partakeInNum = partakeInNum;
    }

    public float getFriendlyNum() {
        return friendlyNum;
    }

    public void setFriendlyNum(float friendlyNum) {
        this.friendlyNum = friendlyNum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userName);
        dest.writeString(this.avatarUrl);
        dest.writeInt(this.launchActCount);
        dest.writeInt(this.partakeInNum);
        dest.writeFloat(this.friendlyNum);
        dest.writeString(this.tel);
        dest.writeByte(this.isPrivate ? (byte) 1 : (byte) 0);
    }

    public UserInfo() {
    }

    protected UserInfo(Parcel in) {
        this.userName = in.readString();
        this.avatarUrl = in.readString();
        this.launchActCount = in.readInt();
        this.partakeInNum = in.readInt();
        this.friendlyNum = in.readFloat();
        this.tel = in.readString();
        this.isPrivate = in.readByte() != 0;
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", launchActCount=" + launchActCount +
                ", partakeInNum=" + partakeInNum +
                ", friendlyNum=" + friendlyNum +
                ", tel='" + tel + '\'' +
                ", isPrivate=" + isPrivate +
                '}';
    }
}
