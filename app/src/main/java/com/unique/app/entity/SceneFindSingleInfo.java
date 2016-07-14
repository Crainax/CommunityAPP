package com.unique.app.entity;

import android.os.Parcel;

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
public class SceneFindSingleInfo extends SceneFindInfo {

    private EvaluateInfo evaluateInfo;

    public EvaluateInfo getEvaluateInfo() {
        return evaluateInfo;
    }

    public void setEvaluateInfo(EvaluateInfo evaluateInfo) {
        this.evaluateInfo = evaluateInfo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(this.evaluateInfo, flags);
    }

    public SceneFindSingleInfo() {
    }

    protected SceneFindSingleInfo(Parcel in) {
        super(in);
        this.evaluateInfo = in.readParcelable(EvaluateInfo.class.getClassLoader());
    }

    public static final Creator<SceneFindSingleInfo> CREATOR = new Creator<SceneFindSingleInfo>() {
        @Override
        public SceneFindSingleInfo createFromParcel(Parcel source) {
            return new SceneFindSingleInfo(source);
        }

        @Override
        public SceneFindSingleInfo[] newArray(int size) {
            return new SceneFindSingleInfo[size];
        }
    };
}
