package com.unique.app.entity;

import android.os.Parcel;

import java.util.List;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.entity <br/>
 * Description: bean类,Scene_Find基类,多人的<br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/9 <br/>
 */
public class SceneFindMultiInfo extends SceneFindInfo {

    private List<EvaluateInfo> evaluateInfo;
    private int currentPeopleCount;
    private int totalPeopleCount;

    public List<EvaluateInfo> getEvaluateInfo() {
        return evaluateInfo;
    }

    public void setEvaluateInfo(List<EvaluateInfo> evaluateInfo) {
        this.evaluateInfo = evaluateInfo;
    }

    public int getCurrentPeopleCount() {
        return currentPeopleCount;
    }

    public void setCurrentPeopleCount(int currentPeopleCount) {
        this.currentPeopleCount = currentPeopleCount;
    }

    public int getTotalPeopleCount() {
        return totalPeopleCount;
    }

    public void setTotalPeopleCount(int totalPeopleCount) {
        this.totalPeopleCount = totalPeopleCount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(this.evaluateInfo);
        dest.writeInt(this.currentPeopleCount);
        dest.writeInt(this.totalPeopleCount);
    }

    public SceneFindMultiInfo() {
    }

    protected SceneFindMultiInfo(Parcel in) {
        super(in);
        this.evaluateInfo = in.createTypedArrayList(EvaluateInfo.CREATOR);
        this.currentPeopleCount = in.readInt();
        this.totalPeopleCount = in.readInt();
    }

    public static final Creator<SceneFindMultiInfo> CREATOR = new Creator<SceneFindMultiInfo>() {
        @Override
        public SceneFindMultiInfo createFromParcel(Parcel source) {
            return new SceneFindMultiInfo(source);
        }

        @Override
        public SceneFindMultiInfo[] newArray(int size) {
            return new SceneFindMultiInfo[size];
        }
    };
}
