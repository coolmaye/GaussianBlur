package com.kela.gausspicture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.kela.gausspicture.ndk.Codec;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView blur = (ImageView) findViewById(R.id.blur);
        ImageView blur2 = (ImageView) findViewById(R.id.blur2);
        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.beijing);

        //利用高斯模糊算法进行模糊
        Bitmap bitmap1 = Codec.gaussBlurUseGauss(bitmap, 20);
        blur.setImageBitmap(bitmap1);

        //利用均值模糊进行模糊，效率会比高斯模糊高
        Bitmap bitmap2 = Codec.gaussBlurUseAvg(bitmap, 20);
        blur2.setImageBitmap(bitmap2);
    }
}
