package com.unique.app.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.unique.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Project: CommnitiAPP <br/>
 * Package: com.unique.app.ui <br/>
 * Description: <br/>
 * <hr/>
 *
 * @author Crainax <br/>
 * @version 1.0 <br/>
 * @since 2016/7/14 <br/>
 */
public class PictureActivity extends BaseActivity {

    public static final String EXTRA_IMAGE_URL = "image_url";
    public static final String TRANSIT_PIC = "picture";

    @BindView(R.id.iv_photo)
    ImageView mImageView;

    PhotoViewAttacher mPhotoViewAttacher;
    String mImageUrl;

    public static void start(Activity activity, String url, View transitionView) {
        Intent intent = new Intent(activity, PictureActivity.class);
        intent.putExtra(PictureActivity.EXTRA_IMAGE_URL, url);
        ActivityOptionsCompat optionsCompat
                = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity, transitionView, PictureActivity.TRANSIT_PIC);
        try {
            ActivityCompat.startActivity(activity, intent,
                    optionsCompat.toBundle());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            activity.startActivity(intent);
        }
    }

    private void parseIntent() {
        mImageUrl = getIntent().getStringExtra(EXTRA_IMAGE_URL);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        parseIntent();
        // init image view
        ViewCompat.setTransitionName(mImageView, TRANSIT_PIC);
        Glide.with(this).load(mImageUrl).dontAnimate().into(mImageView);
        setupPhotoAttacher();
    }


    private void setupPhotoAttacher() {
        mPhotoViewAttacher = new PhotoViewAttacher(mImageView);
        mPhotoViewAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float v, float v1) {
                onBackPressed();
            }
        });
    }
}
