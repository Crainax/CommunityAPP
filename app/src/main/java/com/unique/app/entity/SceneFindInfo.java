package com.unique.app.entity;

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
public class SceneFindInfo {

    private String title;
    private boolean isLike;
    private TagInfo[] tagInfos;
    private Date date;
    private UserInfo user;

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

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
