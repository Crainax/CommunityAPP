package com.unique.app.debbug;

import android.support.annotation.NonNull;

import com.unique.app.entity.EvaluateInfo;
import com.unique.app.entity.SceneFindMultiInfo;
import com.unique.app.entity.SceneFindSingleInfo;
import com.unique.app.entity.UserInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.debbug <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/13 <br/>
 */
public class FakeUtils {

    @FakeContent
    public static List<UserInfo> fakeUserInfo(int num) {

        List<UserInfo> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(fakeUserInfo());
        }

        return list;
    }

    @FakeContent
    public static UserInfo fakeUserInfo() {

        Random random = new Random();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("用户" + random.nextInt(100000));
        userInfo.setLaunchActCount(random.nextInt(10));
        userInfo.setPartakeInNum(random.nextInt(20));
        userInfo.setFriendlyNum(random.nextFloat() * 5);
        userInfo.setPrivate(random.nextBoolean());
        userInfo.setTel(random.nextLong() + "");
        switch (random.nextInt(2)) {
            case 0:
                userInfo.setAvatarUrl("http://avatar.csdn.net/1/D/D/1_xipiaoyouzi.jpg");
                break;
            case 1:
                userInfo.setAvatarUrl("http://avatar.csdn.net/A/6/6/1_xuewater.jpg");
                break;
        }

        return userInfo;
    }


    @FakeContent
    public static List<SceneFindSingleInfo> fakeSceneFindSingleInfo(int num) {

        List<SceneFindSingleInfo> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            SceneFindSingleInfo sceneFindSingleInfo = fakeSceneFindSingleInfo();
            list.add(sceneFindSingleInfo);
        }

        return list;
    }

    @NonNull
    private static SceneFindSingleInfo fakeSceneFindSingleInfo() {
        Random random = new Random();
        EvaluateInfo evaluateInfo = fakeEvaluateInfo();
        SceneFindSingleInfo sceneFindSingleInfo = new SceneFindSingleInfo();
        sceneFindSingleInfo.setDate(new Date(random.nextLong()));
        sceneFindSingleInfo.setEvaluateInfo(evaluateInfo);
        sceneFindSingleInfo.setLike(random.nextBoolean());
        sceneFindSingleInfo.setTagInfos(null);
        sceneFindSingleInfo.setTitle("标题" + random.nextInt(100));
        return sceneFindSingleInfo;
    }


    @FakeContent
    public static List<SceneFindMultiInfo> fakeSceneFindMultiInfo(int num) {

        List<SceneFindMultiInfo> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            SceneFindMultiInfo sceneFindMultiInfo = fakeSceneFindInfo();
            list.add(sceneFindMultiInfo);
        }

        return list;
    }

    @NonNull
    private static SceneFindMultiInfo fakeSceneFindInfo() {
        Random random = new Random();
        SceneFindMultiInfo sceneFindMultiInfo = new SceneFindMultiInfo();
        sceneFindMultiInfo.setDate(new Date(random.nextLong()));
        int total = random.nextInt(10) + 1;
        int current = random.nextInt(total);
        List<EvaluateInfo> infos = fakeEvaluateInfo(current);
        sceneFindMultiInfo.setCurrentPeopleCount(current);
        sceneFindMultiInfo.setTotalPeopleCount(total);
        sceneFindMultiInfo.setEvaluateInfo(infos);
        sceneFindMultiInfo.setLike(random.nextBoolean());
        sceneFindMultiInfo.setTagInfos(null);
        sceneFindMultiInfo.setTitle("标题" + random.nextInt(100));
        return sceneFindMultiInfo;
    }

    @NonNull
    private static EvaluateInfo fakeEvaluateInfo() {
        Random random = new Random();
        EvaluateInfo evaluateInfo = new EvaluateInfo();
        evaluateInfo.setRating(random.nextFloat() * 5);
        evaluateInfo.setEvaluate(random.nextBoolean());
        evaluateInfo.setUserInfo(fakeUserInfo());
        return evaluateInfo;
    }

    public static List<EvaluateInfo> fakeEvaluateInfo(int num) {
        List<EvaluateInfo> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            EvaluateInfo evaluateInfo = fakeEvaluateInfo();
            list.add(evaluateInfo);
        }

        return list;

    }
}
