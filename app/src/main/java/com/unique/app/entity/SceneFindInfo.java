package com.unique.app.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.entity <br/>
 * Description: bean类,Scene_Find基类<br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/9 <br/>
 */
public abstract class SceneFindInfo implements Parcelable{

    private String title;
    private boolean isLike;
    private TagInfo[] tagInfos;
    private Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public TagInfo[] getTagInfos() {
        return tagInfos;
    }

    public void setTagInfos(TagInfo[] tagInfos) {
        this.tagInfos = tagInfos;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeByte(this.isLike ? (byte) 1 : (byte) 0);
        dest.writeTypedArray(this.tagInfos, flags);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
    }

    public SceneFindInfo() {
    }

    protected SceneFindInfo(Parcel in) {
        this.title = in.readString();
        this.isLike = in.readByte() != 0;
        this.tagInfos = in.createTypedArray(TagInfo.CREATOR);
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
    }

}
