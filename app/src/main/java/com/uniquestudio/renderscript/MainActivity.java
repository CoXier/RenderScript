package com.uniquestudio.renderscript;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.uniquestudio.renderscript.util.MagnifierUtil;

public class MainActivity extends AppCompatActivity {
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.iv);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        bitmap = MagnifierUtil.magnifierBitmap(bitmap, 1000, 400,300, 3, this);
        mImageView.setImageBitmap(bitmap);
    }
}
