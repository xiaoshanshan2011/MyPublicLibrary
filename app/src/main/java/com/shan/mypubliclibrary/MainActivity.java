package com.shan.mypubliclibrary;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.shan.publiclibrary.utils.ImageUtil;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        File file = new File(Environment.getExternalStorageDirectory(),"shanshan");
        if (!file.exists()){
            file.mkdir();
        }
        file = new File(file,"abc.png");
        Bitmap bitmap = ImageUtil.getSmallBitmap(file.getAbsolutePath());
        image.setImageBitmap(bitmap);
    }
}
