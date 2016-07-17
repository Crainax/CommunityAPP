package com.unique.app.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    private Date time;
    private String content;
    private String place;
    private List<String> images;

    /**
     * 0 普通,1付费,2有偿
     */
    private int type;
    /**
     * 0 有效,1已取消
     */
    private int state;


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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
        dest.writeLong(this.time != null ? this.time.getTime() : -1);
        dest.writeString(this.content);
        dest.writeString(this.place);
        dest.writeStringList(this.images);
        dest.writeInt(this.type);
        dest.writeInt(this.state);
    }

    public SceneFindInfo() {
    }

    protected SceneFindInfo(Parcel in) {
        this.title = in.readString();
        this.isLike = in.readByte() != 0;
        this.tagInfos = in.createTypedArray(TagInfo.CREATOR);
        long tmpTime = in.readLong();
        this.time = tmpTime == -1 ? null : new Date(tmpTime);
        this.content = in.readString();
        this.place = in.readString();
        this.images = in.createStringArrayList();
        this.type = in.readInt();
        this.state = in.readInt();
    }


    @Override
    public String toString() {
        return "SceneFindInfo{" +
                "title='" + title + '\'' +
                ", isLike=" + isLike +
                ", tagInfos=" + Arrays.toString(tagInfos) +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", place='" + place + '\'' +
                ", images=" + images +
                ", type=" + type +
                ", state=" + state +
                '}';
    }
}
