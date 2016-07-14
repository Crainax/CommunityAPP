package com.unique.app.debbug;

import com.unique.app.entity.EvaluateInfo;
import com.unique.app.entity.SceneFindInfo;
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
    public static List<SceneFindInfo> fakeSceneFindInfo(int num) {

        List<SceneFindInfo> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Random random = new Random();
            EvaluateInfo evaluateInfo = new EvaluateInfo();
            evaluateInfo.setRating(random.nextFloat() * 5);
            evaluateInfo.setEvaluate(random.nextBoolean());
            evaluateInfo.setUserInfo(fakeUserInfo());
            SceneFindInfo sceneFindInfo = new SceneFindInfo();
            sceneFindInfo.setDate(new Date(random.nextLong()));
            sceneFindInfo.setEvaluateInfo(evaluateInfo);
            sceneFindInfo.setLike(random.nextBoolean());
            sceneFindInfo.setTagInfos(null);
            sceneFindInfo.setTitle("标题" + random.nextInt(100));
            list.add(sceneFindInfo);
        }

        return list;
    }

    public static List<EvaluateInfo> fakeEvaluateInfo(int num) {
        return null;
    }
}
