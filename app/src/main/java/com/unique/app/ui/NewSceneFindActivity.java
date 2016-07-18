package com.unique.app.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.GetDataCallback;
import com.orhanobut.logger.Logger;
import com.unique.app.R;
import com.unique.app.debbug.FakeUtils;
import com.unique.app.entity.SceneFindInfo;
import com.unique.app.entity.SceneFindMultiInfo;
import com.unique.app.entity.SceneFindSingleInfo;
import com.unique.app.entity.UserInfo;
import com.unique.app.ui.adapter.NewImageAdapter;
import com.unique.app.ui.adapter.NewTagAdapter;
import com.unique.app.ui.view.CenterToolbar;
import com.unique.app.ui.view.NewSceneItemView;
import com.unique.app.util.AlertDialogUtils;
import com.unique.app.util.DataUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/15 <br/>
 */
public class NewSceneFindActivity extends BaseActivity
        implements CenterToolbar.OnToolbarBackClickListener
        , CompoundButton.OnCheckedChangeListener
        , NewImageAdapter.OnNewImageItemClickListener
        , NewTagAdapter.OnNewTagClickListener {

    private static final int REQUEST_IMAGE = 1;

    @BindView(R.id.toolbar)
    CenterToolbar mToolbar;
    @BindView(R.id.et_new_scene_title)
    EditText etNewSceneTitle;
    @BindView(R.id.nsiv_new_scene_time)
    NewSceneItemView nsivNewSceneTime;
    @BindView(R.id.nsiv_new_scene_location)
    NewSceneItemView nsivNewSceneLocation;
    @BindView(R.id.nsiv_new_scene_desc)
    NewSceneItemView nsivNewSceneDesc;
    @BindView(R.id.rb_new_scene_single)
    RadioButton rbNewSceneSingle;
    @BindView(R.id.rb_new_scene_multi)
    RadioButton rbNewSceneMulti;
    @BindView(R.id.et_new_scene_people_count)
    EditText etNewScenePeopleCount;
    @BindView(R.id.rb_new_scene_have_pay)
    RadioButton rbNewSceneHavePay;
    @BindView(R.id.rb_new_scene_pay)
    RadioButton rbNewScenePay;
    @BindView(R.id.rv_new_scene_tag)
    RecyclerView rvNewSceneTag;
    @BindView(R.id.rv_new_scene_image)
    RecyclerView rvNewSceneImage;
    private NewImageAdapter mImageAdapter;
    private NewTagAdapter mTagAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, NewSceneFindActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_scene_find);
        ButterKnife.bind(this);

        initToolbar();
        initTagRecyclerView();
        initImageRecyclerView();

        initRadioGroup();
    }

    private void initRadioGroup() {

        //默认不能编辑
        rbNewSceneSingle.setChecked(true);
        etNewScenePeopleCount.setEnabled(false);
        //变化监听触发可逻辑
        rbNewSceneSingle.setOnCheckedChangeListener(this);
    }

    private void initTagRecyclerView() {

        mTagAdapter = new NewTagAdapter(new ArrayList<String>(), 5);

        rvNewSceneTag.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNewSceneTag.setAdapter(mTagAdapter);
        mTagAdapter.setOnNewTagClickListener(this);
    }

    private void initToolbar() {
        mToolbar.setTitle("发布场景");
        mToolbar.enableBackButton(true);
        mToolbar.setOnToolbarBackClickListener(this);
    }

    private void initImageRecyclerView() {

        mImageAdapter = new NewImageAdapter(new ArrayList<AVFile>(), 2);

        rvNewSceneImage.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNewSceneImage.setAdapter(mImageAdapter);
        mImageAdapter.setOnNewImageItemClickListener(this);

    }


    @Override
    public void onToolbarBackClick(View view) {
        this.onBackPressed();
    }

    /**
     * 提交按钮
     */
    @OnClick(R.id.click_new_scene_submit)
    public void onClick() {

        SceneFindInfo info;
        if (isSingle()) {
            SceneFindSingleInfo sceneFindSingleInfo = new SceneFindSingleInfo();
            sceneFindSingleInfo.setUserInfo(FakeUtils.fakeUserInfo());
            info = sceneFindSingleInfo;
        } else {
            SceneFindMultiInfo sceneFindMultiInfo = new SceneFindMultiInfo();
            ArrayList<UserInfo> userInfos = new ArrayList<>();
            userInfos.add(FakeUtils.fakeUserInfo());
            sceneFindMultiInfo.setUserInfos(userInfos);
            info = sceneFindMultiInfo;
        }
        info.setTitle(etNewSceneTitle.getText().toString());
        info.setTime(new Date());
        info.setType(rbNewSceneHavePay.isChecked() ? 1 : rbNewScenePay.isChecked() ? 2 : 0);
        info.setContent(nsivNewSceneDesc.getText());
        info.setTitle(etNewSceneTitle.getText().toString());
        // TODO: 2016/7/16 加入图片保存逻辑,取消场景的like.这是用户的逻辑
        info.setImages(null);
        info.setTags(null);
        info.setPlace(nsivNewSceneLocation.getText());

        if (validateData(info) == null) {
            // 如果验证没错
            Logger.i("onClick: " + info);
        } else {
            // 如果验证有错
        }
    }

    /**
     * 判断是否是单人的场景信息
     */
    private boolean isSingle() {
        return rbNewSceneSingle.isChecked();
    }

    @Override
    public void onBackPressed() {
        AlertDialogUtils.show(this, "确认", "确认离开么?离开后内容将不保存", "确认", "取消", new AlertDialogUtils.OkCallBack() {
            @Override
            public void onOkClick(DialogInterface dialog, int which) {
                NewSceneFindActivity.this.finish();
            }
        }, null);
    }

    /**
     * 单人或多人变化的监听
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked)
            //如果是单人,取消文本可编辑
            etNewScenePeopleCount.setEnabled(false);
        else
            //反之则可编辑
            etNewScenePeopleCount.setEnabled(true);
    }


    /**
     * 验证信息
     */
    private Throwable validateData(SceneFindInfo sceneFindInfo) {

        return null;
    }

    @Override
    public void onImageItemClick(final View view, final AVFile avFile) {
        // TODO: 2016/7/17 使用元数据Metadata

        String url = (String) avFile.getMetaData(PictureActivity.META_AVFILE_NAME);
        if (url != null)
            PictureActivity.start(NewSceneFindActivity.this, url, view);
        else
            avFile.getDataInBackground(new GetDataCallback() {
                @Override
                public void done(byte[] bytes, AVException e) {
                    if (e == null) {
                        PictureActivity.start(NewSceneFindActivity.this, bytes, view);
                    } else {
                        e.printStackTrace();
                    }
                }
            });
    }

    @Override
    public void onMoreClick(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_IMAGE);
    }

    @Override
    public void onImageItemLongClick(View view, AVFile avFile) {
        mImageAdapter.removeImage(avFile);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (data == null)
                return;
            switch (requestCode) {
                //接收回图片
                case REQUEST_IMAGE:
                    String pathUri = DataUtils.getPathUrl(this, data);
                    if (pathUri != null) {
                        File pathFile = DataUtils.getPathFile(this, data);
                        if (pathFile != null) {
                            try {
                                AVFile avFile = AVFile.withFile(pathFile.getName(), pathFile);
                                avFile.addMetaData(PictureActivity.META_AVFILE_NAME, pathUri);
                                //加入图片列表
                                mImageAdapter.addImage(avFile);
                            } catch (FileNotFoundException e) {
                                Toast.makeText(NewSceneFindActivity.this, "图片文件出错.", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();

                            }
                        }
                    }
                    break;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onNewTagClick(View view) {
        final EditText et = new EditText(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请输入Tag")
                .setView(et)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mTagAdapter.addTag(et.getText().toString());
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }

    @Override
    public void onTagItemClick(View view, String tag) {

    }

    @Override
    public void onTagItemLongClick(View v, String tag) {
        mTagAdapter.removeTag(tag);
    }
}
